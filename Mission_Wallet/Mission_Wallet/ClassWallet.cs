using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mission_Wallet
{
    class ClassWallet
    {
        public string name;
        public double balance;
        public List <ClassTransaction> transactions = new List<ClassTransaction>();
        public ClassDepit DepitCard = new ClassDepit();

        public ClassWallet(string name, double balance)
        {
            this.name = name;
            this.balance = balance;
        }
    }
}
