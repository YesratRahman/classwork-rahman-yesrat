using System;
using _223RoomEscape.Classes.Armor;
using _223RoomEscape.Classes.Weapon;
using _223RoomEscape.Interfaces;

namespace _223RoomEscape.Classes.Fighter
{
    public class Troll : Fighter
    {
        public Troll()
        {
            Name = "Troll";
            Health = 10;
            Weapon = new Crossbow();
            Armor = new Helmet();
        }

        public Troll(string name, int health, string weapon, string armor, int potion)
        {
            Name = name;
            Health = health;
            Weapon = GetWeapon(weapon);
            Armor = GetArmor(armor);
            Potion = potion;
        }
        public Troll(int health, string name, IArmor armor, IWeapon weapon)
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
            Health -= Armor.ReduceDamage(dmg);
        }
    }
}
