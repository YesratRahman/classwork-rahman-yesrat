using System;
using _223RoomEscape.Classes.Armor;
using _223RoomEscape.Classes.Weapon;
using _223RoomEscape.Interfaces;

namespace _223RoomEscape.Classes.Fighter
{
    public abstract class Fighter : IFighter, IHealthy, INamed
    {
        public Fighter()
        {
        }

        public Fighter(string name, int health, string weapon, string armor, int potion)
        {
            Name = name;
            Health = health;
            Weapon = GetWeapon(weapon);
            Armor = GetArmor(armor);
            Potion = potion;
        }

        public IWeapon Weapon { get; set; }

        public IArmor Armor { get; set; }

        public int Potion { get; set; }

        public int Health { get; set; }

        public string Name { get; set; }

        public abstract void Attack(IFighter toAttack);

        public abstract void Defend(int dmg);

        public IWeapon GetWeapon(string weapon)
        {
            IWeapon newWeapon = null;
            switch (weapon)
            {
                case "Fists":
                    newWeapon = new Fists();
                    break;
                case "Sword":
                    newWeapon = new Sword();
                    break;
                case "Crossbow":
                    newWeapon = new Crossbow();
                    break;
            }

            return newWeapon;
        }

        public IArmor GetArmor(string armor)
        {
            IArmor newArmor = null;
            switch (armor)
            {
                case "Helmet":
                    newArmor = new Helmet();
                    break;
                case "Shirt":
                    newArmor = new Shirt();
                    break;
                case "Shield":
                    newArmor = new Shield();
                    break;
            }

            return newArmor;
        }

        public void Defend(object v)
        {
            throw new NotImplementedException();
        }
    }
}
