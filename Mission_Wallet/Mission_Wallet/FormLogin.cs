using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace Mission_Wallet
{
    public partial class FormLogin : Form
    {
        ClassUser[] users = { new ClassUser("Reem", "111"), new ClassUser("Miro", "222"), new ClassUser("Malak", "333") };
        public delegate void delPassDataToFrom(Object obj);

        SqlConnection con = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=|DataDirectory|\PARTFOUR.mdf;Integrated Security=True");
        public FormLogin()
        {
            InitializeComponent();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void txtUsername_MouseClick(object sender, MouseEventArgs e)
        {
            if (txtUsername.Text == "Username...")
            {
                txtUsername.Clear();
            }
        }

        private void txtUsername_Leave(object sender, EventArgs e)
        {
            if (txtUsername.Text == "")
            {
                txtUsername.Text= "Username...";
            }
        }

        private void txtPassward_MouseClick(object sender, MouseEventArgs e)
        {
            if (txtPassward.Text == "Password...")
            {
                txtPassward.Clear();
                txtPassward.PasswordChar = '*';
            }
        }

        private void txtPassward_Leave(object sender, EventArgs e)
        {
            if (txtPassward.Text == "")
            {
                txtPassward.Text = "Password...";
                txtPassward.PasswordChar = Convert.ToChar(0);

            }
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            try
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("select *from LoginTable where username ='"+ txtUsername.Text + "' and pass = '"+ txtPassward.Text + "' ", con);
                SqlDataReader rd = cmd.ExecuteReader();
                if (rd.Read())
                {
                    ClassUser user = new ClassUser();
                    for(int i=0; i<3; i++)
                    {
                        if (txtUsername.Text.ToLower() == users[i].username.ToLower())
                        {
                            user = users[i];
                        }
                    }
                    FormWallets next = new FormWallets(txtUsername.Text);
                    delPassDataToFrom del = new delPassDataToFrom(next.retrieveData);
                    del(user);
                    //this.Hide();
                    next.Show();

                }
                else
                    MessageBox.Show("you had entered incorrect user detial , please try again","Incorrect detail");                            
                        
                con.Close(); 
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
                con.Close();
            }
        }
    }
}
