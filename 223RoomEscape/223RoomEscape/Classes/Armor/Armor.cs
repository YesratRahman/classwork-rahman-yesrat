using System;
using _223RoomEscape.Interfaces;

namespace _223RoomEscape.Classes.Armor
{
    public abstract class Armor : IArmor
    {
        public Armor()
        {
        }

        public Armor(int durability)
        {
            Durability = durability;
        }

        public int Durability { get; set; }

        public abstract int ReduceDamage(int incomingDamage);
    }
} 