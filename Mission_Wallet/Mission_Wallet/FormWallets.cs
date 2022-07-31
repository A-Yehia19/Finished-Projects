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
    public partial class FormWallets : Form
    {
        ClassUser person;
        public delegate void delPassDataToFrom(Object obj);
        public void retrieveData(Object objPassedFromParent)
        {
            person = objPassedFromParent as ClassUser;
        }
        public FormWallets(string user)
        {
            InitializeComponent();
            label_Greeting.Text = "Hello " + user;
        }

        private void textBox_NewWallet_Leave(object sender, EventArgs e)
        {
            if (textBox_WalletName.Text == "")
                textBox_WalletName.Text = "Enter the Name...";
        }

        private void textBox_NewWallet_Enter(object sender, EventArgs e)
        {
            if (textBox_WalletName.Text == "Enter the Name...")
                textBox_WalletName.Text = "";
        }

        private void textBox_WalletBalance_Enter(object sender, EventArgs e)
        {
            if (textBox_WalletBalance.Text == "Enter the Balance...")
                textBox_WalletBalance.Text = "";
        }

        private void textBox_WalletBalance_Leave(object sender, EventArgs e)
        {
            if (textBox_WalletBalance.Text == "")
                textBox_WalletBalance.Text = "Enter the Balance...";
        }

        private void button_CreateWallet_Click(object sender, EventArgs e)
        {
            try
            {
                if (textBox_WalletName.Text == "Enter the Name...")
                    MessageBox.Show("Please enter wallet name!");
                else
                {
                    person.wallets.Add(new ClassWallet(textBox_WalletName.Text, Convert.ToDouble(textBox_WalletBalance.Text)));
                    listBox_Wallets.Items.Add(textBox_WalletName.Text);
                }
            }
            catch (Exception)
            {
                if(textBox_WalletBalance.Text== "Enter the Balance...")
                    MessageBox.Show("Please enter the balance!");
                else
                    MessageBox.Show("The balance should be a number!");
            }
        }

        private void button_DeleteWallet_Click(object sender, EventArgs e)
        {
            try
            {
                int idx = person.wallets.FindIndex(x => x.name == Convert.ToString(listBox_Wallets.SelectedItem));
                person.wallets.RemoveAt(idx);
                listBox_Wallets.Items.RemoveAt(listBox_Wallets.SelectedIndex);
            }
            catch (Exception)
            {
                MessageBox.Show("Please select a wallet!");
            }
        }

        private void button_EnterWallet_Click(object sender, EventArgs e)
        {
            try
            {
                ClassWallet tosend = person.wallets[listBox_Wallets.SelectedIndex];

                FormRobotHumanCheck next = new FormRobotHumanCheck();
                delPassDataToFrom del = new delPassDataToFrom(next.retrieveData);
                del(tosend);
                this.Hide();
                next.Show();
            }
            catch(Exception)
            {
                MessageBox.Show("Please select a wallet!");
            }
        }

        private void WalletsForm_Load(object sender, EventArgs e)
        {
            for (int i = 0; i < person.wallets.Count; i++)
            {
                listBox_Wallets.Items.Add(person.wallets[i].name);
            }
        }
    }
}
