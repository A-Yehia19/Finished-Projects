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
    public partial class FormRobotHumanCheck : Form
    {
        ClassWallet wallet;
        public delegate void delPassDataToFrom(Object obj);
        public void retrieveData(Object objPassedFromParent)
        {
            wallet = objPassedFromParent as ClassWallet;
        }
        public FormRobotHumanCheck()
        {
            InitializeComponent();
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            FormAccessGranted next = new FormAccessGranted();
            delPassDataToFrom del = new delPassDataToFrom(next.retrieveData);
            del(wallet);
            next.Show();
            Visible = false;
            
        }
    }
}
