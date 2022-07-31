using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mission_Wallet
{
    class ClassExpenses : ClassTransaction
    {
        public double FoodAndDrinks = 0;
        public double Bill = 0;
        public double HouseRent = 0;
        public double FixAndMaintenance = 0;
        public double Entertainment = 0;
        public double Health = 0;
        public ClassProduct Others = new ClassProduct("",0);

        public double Total()
        {
            total = FoodAndDrinks + Bill + HouseRent + FixAndMaintenance + Entertainment + Health + Others.ProdPrice;
            return total;
        }
    }
}
