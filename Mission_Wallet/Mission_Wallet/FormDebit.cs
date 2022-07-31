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
    public partial class FormDebit : Form
    {
        ClassWallet wallet;
        public void retrieveData(Object objPassedFromParent)
        {
            wallet = objPassedFromParent as ClassWallet;
        }
        public FormDebit()
        {
            InitializeComponent();
        }

        private void DebitForm_FormClosed(object sender, FormClosedEventArgs e)
        {
            //AccessGrantedForm soda = new AccessGrantedForm();
            //soda.Show();
        }

        private void btn_done_Click(object sender, EventArgs e)
        {
            try
            {
                wallet.DepitCard.DepitNum = Convert.ToDouble(textBox_Number.Text);
                wallet.DepitCard.ExpireDate = Convert.ToString(dateTimePicker_Date.Text);
                this.Close();
            }
            catch (Exception)
            {
                MessageBox.Show("Depit number should contain only numbers!");
            }
        }

        private void DebitForm_Load(object sender, EventArgs e)
        {
            textBox_Balance.Text = Convert.ToString(wallet.balance);
            textBox_Name.Text = wallet.name;
        }
    }
}
