using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mission_Wallet
{
    class ClassIncome : ClassTransaction
    {
        public double Salary = 0;
        public double Award = 0;
        public double Interest = 0;
        public ClassProduct Others = new ClassProduct("", 0);

        public double Total()
        {
            total = Salary + Award + Interest + Others.ProdPrice;
            return total;
        }
    }
}
