using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mission_Wallet
{
    class ClassProduct
    {
        public string ProdName;
        public double ProdPrice;

        public ClassProduct(string name, double price)
        {
            ProdName = name;
            ProdPrice = price;
        }
    }
}
