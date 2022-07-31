using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Mission_Wallet
{
    public partial class FormReport : Form
    {
        ClassWallet wallet;
        public void retrieveData(Object objPassedFromParent)
        {
            wallet = objPassedFromParent as ClassWallet;
        }
        public FormReport()
        {
            InitializeComponent();
        }

        private void Report_Load(object sender, EventArgs e)
        {
           string tmp = "";
            tmp += depitinfo();
            for(int i=0 ; i<wallet.transactions.Count ; i++)
            {
                if(wallet.transactions[i] is ClassIncome)
                {
                    tmp += "--------------------------------------------------------------\r\n";
                    tmp += incomedata((ClassIncome)wallet.transactions[i]);
                }
                else
                {
                    tmp += "--------------------------------------------------------------\r\n";
                    tmp += expensedata((ClassExpenses)wallet.transactions[i]);
                }
            }
            textBox_Report.Text = tmp;
        }

        private string depitinfo()
        {
            return String.Format("Depit info:-\r\nWallet name: {0}\r\nBalance: {1}\r\nDepit Number: {2}\r\nExpiry Date: {3}\r\n",wallet.name,wallet.balance,wallet.DepitCard.DepitNum, wallet.DepitCard.ExpireDate);
        }

        private string expensedata(ClassExpenses expenses)
        {
            return String.Format("Expenses:-\r\nDate: {0}\r\nFoodAndDrinks: {1}\r\nBillHouseRent: {2}\r\nHealth: {3}\r\nFixAndMaintenance: {4}\r\nEntertainment: {5}\r\nOthers: {6} -> {7}\r\n", expenses.Date,expenses.FoodAndDrinks, expenses.Bill, expenses.HouseRent, expenses.FixAndMaintenance, expenses.Entertainment, expenses.Health, expenses.Others.ProdName, expenses.Others.ProdPrice);
        }

        private string incomedata(ClassIncome income)
        {
            return String.Format("Incomes:-\r\nDate: {0}\r\nSalary: {1}\r\nAward: {2}\r\nInterest: {3}\r\nOthers: {4} -> {5}\r\n",income.Date, income.Salary, income.Award, income.Interest, income.Others.ProdName, income.Others.ProdPrice);
        }
    }
}
