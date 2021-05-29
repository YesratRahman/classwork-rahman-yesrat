using System;
namespace _223RoomEscape.Interfaces
{
    public interface IFighter : IHealthy, INamed
    {
        public void Attack(IFighter toAttack);

        public void Defend(int dmg);
        void Defend(object v);
    }
}
