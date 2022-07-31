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
    public partial class FormAccessGranted : Form
    {
        ClassWallet wallet;
        public delegate void delPassDataToFrom(Object obj);
        public void retrieveData(Object objPassedFromParent)
        {
            wallet = objPassedFromParent as ClassWallet;
        }
        public FormAccessGranted()
        {
            InitializeComponent();
        }

        private void btn_E_Click(object sender, EventArgs e)
        {
            FormExpenses next = new FormExpenses();
            delPassDataToFrom del = new delPassDataToFrom(next.retrieveData);
            del(wallet);
            next.ShowDialog();
        }

        private void btn_I_Click(object sender, EventArgs e)
        {
            FormIncomes next = new FormIncomes();
            delPassDataToFrom del = new delPassDataToFrom(next.retrieveData);
            del(wallet);
            next.ShowDialog();
        }

        private void btn_D_Click(object sender, EventArgs e)
        {
            FormDebit next = new FormDebit();
            delPassDataToFrom del = new delPassDataToFrom(next.retrieveData);
            del(wallet);
            next.ShowDialog();
        }

        private void label_Report_Click(object sender, EventArgs e)
        {
            FormReport next = new FormReport();
            delPassDataToFrom del = new delPassDataToFrom(next.retrieveData);
            del(wallet);
            next.ShowDialog();
        }

        private void AccessGrantedForm_Load(object sender, EventArgs e)
        {
            label_WalletName.Text = wallet.name;
        }
    }
}
