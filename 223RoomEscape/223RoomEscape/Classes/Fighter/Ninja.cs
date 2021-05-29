using System;
using _223RoomEscape.Classes.Armor;
using _223RoomEscape.Classes.Weapon;
using _223RoomEscape.Interfaces;

namespace _223RoomEscape.Classes.Fighter
{
    public class Ninja : Fighter
    {
        public Ninja()
        {
            Name = "Ninja";
            Health = 8;
            Weapon = new Fists();
            Armor = new Shirt();
        }

        public Ninja(string name, int health, string weapon, string armor, int potion)
        {
            Name = name;
            Health = health;
            Weapon = GetWeapon(weapon);
            Armor = GetArmor(armor);
            Potion = potion;
        }
        public Ninja(int health, string name, IArmor armor, IWeapon weapon)
        {
            Health = health;
            Name = name;
            Armor = armor;
            Weapon = weapon;

        }
        public override void Attack(IFighter toAttack)
        {
            toAttack.Defend(Weapon.Damage);
        }

        public override void Defend(int dmg)
        {
            Random rand = new Random();

            if (rand.Next(0, 5) != 0)
            {
                Health -= Armor.ReduceDamage(dmg);
            }
        }
    }
}
