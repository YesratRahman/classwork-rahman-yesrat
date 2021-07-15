using Microsoft.IdentityModel.Tokens;
using SpringFoodBackend.Exceptions;
using SpringFoodBackend.Models.Auth;
using SpringFoodBackend.Models.Domain;
using SpringFoodBackend.Models.ViewModels.Requests;
using SpringFoodBackend.Repos;
using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Security.Claims;
using System.Text;

namespace SpringFoodBackend.Services
{
    public class SpringFoodService
    {
        ProductRepo _product;
        UserRepo _user;
        CategoryRepo _category;
        InventoryRepo _inventory;
        CartRepo _cart;
        OrderRepo _order;
        public SpringFoodService(SpringFoodDbContext context)
        {
            _product = new ProductRepo(context);
            _user = new UserRepo(context);
            _category = new CategoryRepo(context);
            _inventory = new InventoryRepo(context);
            _cart = new CartRepo(context);
            _order = new OrderRepo(context);
        }

        public void RegisterUser(RegisterUserViewModel toAdd)
        {
            User previouslyUserName = _user.GetUserByUserName(toAdd.Username);
            if (previouslyUserName != null)
            {
                throw new UserNameInUseException(); 
            }
            Role basicRole = _user.GetRoleByName("user");
            UserRole bridgeRow = new UserRole();
            bridgeRow.RoleId = basicRole.Id;
            bridgeRow.SelectedRole = basicRole;

            User toAddUser = new User();
            bridgeRow.EnrolledUser = toAddUser;
            toAddUser.Roles.Add(bridgeRow);

            toAddUser.Email = toAdd.Email;
            toAddUser.Username = toAdd.Username;
            using (var hMac = new System.Security.Cryptography.HMACSHA512())
            {
                byte[] salt = hMac.Key;
                byte[] hash = hMac.ComputeHash(System.Text.Encoding.UTF8.GetBytes(toAdd.Password));
                toAddUser.PasswordSalt = salt;
                toAddUser.PasswordHash = hash;
            }
            _user.AddUser(toAddUser);
        }

       
        public object getOrdersByUserId(int curUserId)
        {
           return _order.GetOrdersByUserId(curUserId);
        }

        public LoginResponse Login(LoginRequest loginRe)
        {
           User curUser =  _user.GetUserByUserName(loginRe.Username);
            bool passValidated = this.ValidatePassword(loginRe.Password, curUser.PasswordSalt, curUser.PasswordHash);
            if (!passValidated)
            {
                throw new InvalidPasswordException(); 
            }
            string token = this.GenerateToken(curUser);
            LoginResponse response = new LoginResponse();
            response.Token = token;
            response.Username = curUser.Username;
            response.IsAdmin = curUser.Roles.Any(r => r.SelectedRole.Name == "Admin");
            return response; 
        }

        private string GenerateToken(User curUser)
        {
            JwtSecurityTokenHandler tokenHandler = new JwtSecurityTokenHandler();
            byte[] key = Encoding.ASCII.GetBytes(AppSettings.Secret);
            SecurityTokenDescriptor tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(
                    curUser.Roles.Select(r => new Claim(
                        ClaimTypes.Role, r.SelectedRole.Name)).Append(
                        new Claim(ClaimTypes.NameIdentifier, curUser.Id.ToString()))),
                Expires = DateTime.UtcNow.AddDays(7), 
                SigningCredentials = new SigningCredentials(new SymmetricSecurityKey(key), SecurityAlgorithms.HmacSha256)
            } ;
            var token = tokenHandler.CreateToken(tokenDescriptor);
            string tokenString = tokenHandler.WriteToken(token);
            return tokenString; 
        }

        private bool ValidatePassword(string password, byte[] passwordSalt, byte[] passwordHash)
        {
            using (var hMac = new System.Security.Cryptography.HMACSHA512(passwordSalt))
            {
               
                byte[] passHased = hMac.ComputeHash(System.Text.Encoding.UTF8.GetBytes(password));
                for(int i = 0; i < passwordHash.Length; i++)
                {
                    if(passwordHash[i] != passHased[i])
                    {
                        return false; 
                    }
                }
                return true; 
               
            }
        }

        public int AddProduct(Product product)
        {
            if (product == null)
            {
                throw new ArgumentNullException("Can't add a null product");
            }
            if (product.Name == null)
            {
                throw new ArgumentNullException("Can't add a product with null name");
            }
            if (product.Description == null)
            {
                throw new ArgumentNullException("Can't add a product with null description");
            }
            if (product.Name == "")
            {
                throw new ArgumentNullException("Can't add a product with empty name");
            }

            return _product.AddProduct(product);
        }

        public List<Product> GetProductByCatId(int id)
        {
            return _category.GetProductByCatId(id);
        }

        public Order GetOrderById(int id)
        {
            return _order.GetOrderById(id);
        }

        public Product GetProductById(int id)
        {
            if (id <= 0)
            {
                throw new InvalidIdException("Invalid Id");

            }
            return _product.GetProductById(id);
        }

        public Product GetProductByName(string name)
        {
            return _product.GetProductByName(name);
        }

        public List<Product> GetAllProducts()
        {
            return _product.GetAllProducts();
        }

        public void DeleteProduct(int id)
        {
            _product.DeleteProduct(id);
        }

        public void EditProduct(Product product)
        {
            _product.EditProduct(product);
        }
        public int AddUser(User toAdd)
        {
            return _user.AddUser(toAdd);
        }

        public List<User> GetAllUsers()
        {
            return _user.GetAllUsers();
        }
        public void EdtUser(User toEdit)
        {
            _user.EditUser(toEdit);
        }
        public User GetUserById(int id)
        {
            return _user.GetUserById(id);
        }
        public void DeleteUser(int id)
        {
            _user.DeleteUser(id);
        }

        public int AddCategory(Category toAdd)
        {
            return _category.AddCategory(toAdd);
        }

        public List<Category> GetAllCategories()
        {
            return _category.GetAllCategories();
        }

        public int AddInventory(Inventory toAdd)
        {
            return _inventory.AddInventory(toAdd);
        }
        public Inventory GetInventoryById(int id)
        {
            return _inventory.GetInventoryById(id);
        }
        public List<Inventory> GetAllInventory()
        {
            return _inventory.GetAllInventory();
        }
        public void EditInventory(Inventory toEdit)
        {
            _inventory.EditInventory(toEdit);
        }
        public void DeleteInventory(int id)
        {
            _inventory.DeleteInventory(id);
        }

        public int AddCart(Cart toAdd)
        {
            return _cart.AddCart(toAdd);
        }
        public Cart GetCartById(int id)
        {
            return _cart.GetCartById(id);
        }
        public List<Cart> GetAllCarts()
        {
            return _cart.GetAllCarts();
        }
        public void EditCart(Cart toEdit)
        {
            _cart.EditCart(toEdit);
        }
        public void DeleteCart(int id)
        {
            _cart.DeleteCart(id);
        }

        public int AddOrder(Order toAdd)
        {
            return _order.AddOrder(toAdd);
        }

        public List<Order> GetAllOrders()
        {
            return _order.GetAllOrders();
        }

        public void EdtOrder(Order toEdit)
        {
            _order.EditOrder(toEdit);
        }

        public void DeleteOrder(int id)
        {
            _order.DeleteOrder(id);
        }

    }
} 
