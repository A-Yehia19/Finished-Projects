using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mission_Wallet
{
    class ClassUser
    {
        public string username;
        private string password;
        public List<ClassWallet> wallets = new List<ClassWallet>();

        public ClassUser() { }
        public ClassUser(string name, string pass)
        {
            username = name;
            password = pass;
        }
    }
}
