using System;
namespace _223RoomEscape.Interfaces
{
    public interface IArmor
    {
        public int ReduceDamage(int incomingDamage);

        int Durability { get; set; }
    }
}
