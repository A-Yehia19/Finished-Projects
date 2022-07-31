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
    public partial class FormExpenses : Form
    {
        ClassWallet wallet;
        public void retrieveData(Object objPassedFromParent)
        {
            wallet = objPassedFromParent as ClassWallet;
        }
        public FormExpenses()
        {
            InitializeComponent();
        }

        private void textBox_Other_Name_Enter(object sender, EventArgs e)
        {
            if (textBox_Other_Name.Text == "Category...")
                textBox_Other_Name.Text = "";
        }

        private void textBox_Other_Name_Leave(object sender, EventArgs e)
        {
            if (textBox_Other_Name.Text == "")
                textBox_Other_Name.Text = "Category...";
        }

        private void textBox_Other_Price_Enter(object sender, EventArgs e)
        {
            if (((TextBox)sender).Text == "0")
                ((TextBox)sender).Text = "";
        }

        private void textBox_Other_Price_Leave(object sender, EventArgs e)
        {
            if (((TextBox)sender).Text == "")
                ((TextBox)sender).Text = "0";
            textBox_Leave(sender, e);
        }

        private void textBox_Leave(object sender, EventArgs e)
        {
            try
            {
                double total = Convert.ToDouble(textBox_Bill.Text) + 
                               Convert.ToDouble(textBox_Entertainment.Text) + 
                               Convert.ToDouble(textBox_Food.Text) + 
                               Convert.ToDouble(textBox_Health.Text) + 
                               Convert.ToDouble(textBox_HouseRent.Text) +
                               Convert.ToDouble(textBox_Maintenance.Text) + 
                               Convert.ToDouble(textBox_Other_Price.Text);
                label_TotalPrice.Text = Convert.ToString(total);
            }
            catch (Exception)
            {
                MessageBox.Show("The price should be a number!");
            }
        }

        private void button_ConfirmPay_Click(object sender, EventArgs e)
        {
            ClassExpenses tmp = new ClassExpenses();
            tmp.Date = dateTimePicker_ExpensesTime.Text;
            tmp.FoodAndDrinks = Convert.ToDouble(textBox_Food.Text);
            tmp.Bill = Convert.ToDouble(textBox_Bill.Text);
            tmp.HouseRent = Convert.ToDouble(textBox_HouseRent.Text);
            tmp.Health = Convert.ToDouble(textBox_Health.Text);
            tmp.FixAndMaintenance = Convert.ToDouble(textBox_Maintenance.Text);
            tmp.Entertainment = Convert.ToDouble(textBox_Entertainment.Text);
            tmp.Others = new ClassProduct(textBox_Other_Name.Text, Convert.ToDouble(textBox_Other_Price.Text));
      
            tmp.total = Convert.ToDouble(label_TotalPrice.Text);
            wallet.transactions.Add(tmp);
            wallet.balance -= tmp.total;
            this.Close();
        }
    }
}
