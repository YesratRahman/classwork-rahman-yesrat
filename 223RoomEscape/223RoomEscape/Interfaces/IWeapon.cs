using System;
namespace _223RoomEscape.Interfaces
{
    public interface IWeapon
    {
        string Name { get; set; }

        int Damage { get; set; }

        int Durability { get; set; }
    }
}
