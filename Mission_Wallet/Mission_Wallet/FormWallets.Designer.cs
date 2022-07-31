
namespace Mission_Wallet
{
    partial class FormWallets
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormWallets));
            this.button_CreateWallet = new System.Windows.Forms.Button();
            this.label_Greeting = new System.Windows.Forms.Label();
            this.listBox_Wallets = new System.Windows.Forms.ListBox();
            this.button_EnterWallet = new System.Windows.Forms.Button();
            this.button_DeleteWallet = new System.Windows.Forms.Button();
            this.textBox_WalletName = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.panel2 = new System.Windows.Forms.Panel();
            this.panel1 = new System.Windows.Forms.Panel();
            this.textBox_WalletBalance = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // button_CreateWallet
            // 
            this.button_CreateWallet.BackColor = System.Drawing.Color.Cyan;
            this.button_CreateWallet.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.button_CreateWallet.Font = new System.Drawing.Font("Calibri", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button_CreateWallet.Location = new System.Drawing.Point(260, 393);
            this.button_CreateWallet.Name = "button_CreateWallet";
            this.button_CreateWallet.Size = new System.Drawing.Size(112, 45);
            this.button_CreateWallet.TabIndex = 0;
            this.button_CreateWallet.Text = "Create Wallet";
            this.button_CreateWallet.UseVisualStyleBackColor = false;
            this.button_CreateWallet.Click += new System.EventHandler(this.button_CreateWallet_Click);
            // 
            // label_Greeting
            // 
            this.label_Greeting.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.label_Greeting.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label_Greeting.ForeColor = System.Drawing.SystemColors.Control;
            this.label_Greeting.Location = new System.Drawing.Point(12, 20);
            this.label_Greeting.Name = "label_Greeting";
            this.label_Greeting.Size = new System.Drawing.Size(360, 25);
            this.label_Greeting.TabIndex = 2;
            this.label_Greeting.Text = "Hello User";
            this.label_Greeting.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // listBox_Wallets
            // 
            this.listBox_Wallets.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(35)))), ((int)(((byte)(36)))), ((int)(((byte)(55)))));
            this.listBox_Wallets.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.listBox_Wallets.ForeColor = System.Drawing.Color.White;
            this.listBox_Wallets.FormattingEnabled = true;
            this.listBox_Wallets.ItemHeight = 29;
            this.listBox_Wallets.Location = new System.Drawing.Point(47, 61);
            this.listBox_Wallets.Name = "listBox_Wallets";
            this.listBox_Wallets.Size = new System.Drawing.Size(219, 265);
            this.listBox_Wallets.TabIndex = 3;
            // 
            // button_EnterWallet
            // 
            this.button_EnterWallet.BackColor = System.Drawing.Color.Cyan;
            this.button_EnterWallet.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button_EnterWallet.Font = new System.Drawing.Font("Calibri", 15F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button_EnterWallet.Location = new System.Drawing.Point(284, 83);
            this.button_EnterWallet.Name = "button_EnterWallet";
            this.button_EnterWallet.Size = new System.Drawing.Size(88, 46);
            this.button_EnterWallet.TabIndex = 4;
            this.button_EnterWallet.Text = "Enter";
            this.button_EnterWallet.UseVisualStyleBackColor = false;
            this.button_EnterWallet.Click += new System.EventHandler(this.button_EnterWallet_Click);
            // 
            // button_DeleteWallet
            // 
            this.button_DeleteWallet.BackColor = System.Drawing.Color.Cyan;
            this.button_DeleteWallet.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.button_DeleteWallet.Font = new System.Drawing.Font("Calibri", 15F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button_DeleteWallet.Location = new System.Drawing.Point(284, 158);
            this.button_DeleteWallet.Name = "button_DeleteWallet";
            this.button_DeleteWallet.Size = new System.Drawing.Size(88, 46);
            this.button_DeleteWallet.TabIndex = 5;
            this.button_DeleteWallet.Text = "Delete";
            this.button_DeleteWallet.UseVisualStyleBackColor = false;
            this.button_DeleteWallet.Click += new System.EventHandler(this.button_DeleteWallet_Click);
            // 
            // textBox_WalletName
            // 
            this.textBox_WalletName.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(35)))), ((int)(((byte)(36)))), ((int)(((byte)(55)))));
            this.textBox_WalletName.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.textBox_WalletName.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.textBox_WalletName.ForeColor = System.Drawing.Color.White;
            this.textBox_WalletName.Location = new System.Drawing.Point(47, 386);
            this.textBox_WalletName.Name = "textBox_WalletName";
            this.textBox_WalletName.Size = new System.Drawing.Size(188, 16);
            this.textBox_WalletName.TabIndex = 6;
            this.textBox_WalletName.Text = "Enter the Name...";
            this.textBox_WalletName.Enter += new System.EventHandler(this.textBox_NewWallet_Enter);
            this.textBox_WalletName.Leave += new System.EventHandler(this.textBox_NewWallet_Leave);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.SystemColors.Control;
            this.label1.Location = new System.Drawing.Point(44, 355);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(125, 15);
            this.label1.TabIndex = 7;
            this.label1.Text = "Create New Wallet";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.SystemColors.Control;
            this.label2.Location = new System.Drawing.Point(44, 45);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(76, 15);
            this.label2.TabIndex = 8;
            this.label2.Text = "My Wallets";
            // 
            // panel2
            // 
            this.panel2.BackColor = System.Drawing.Color.White;
            this.panel2.Location = new System.Drawing.Point(47, 405);
            this.panel2.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(184, 1);
            this.panel2.TabIndex = 9;
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.White;
            this.panel1.Location = new System.Drawing.Point(47, 441);
            this.panel1.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(184, 1);
            this.panel1.TabIndex = 11;
            // 
            // textBox_WalletBalance
            // 
            this.textBox_WalletBalance.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(35)))), ((int)(((byte)(36)))), ((int)(((byte)(55)))));
            this.textBox_WalletBalance.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.textBox_WalletBalance.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.textBox_WalletBalance.ForeColor = System.Drawing.Color.White;
            this.textBox_WalletBalance.Location = new System.Drawing.Point(47, 422);
            this.textBox_WalletBalance.Name = "textBox_WalletBalance";
            this.textBox_WalletBalance.Size = new System.Drawing.Size(188, 16);
            this.textBox_WalletBalance.TabIndex = 10;
            this.textBox_WalletBalance.Text = "Enter the Balance...";
            this.textBox_WalletBalance.Enter += new System.EventHandler(this.textBox_WalletBalance_Enter);
            this.textBox_WalletBalance.Leave += new System.EventHandler(this.textBox_WalletBalance_Leave);
            // 
            // FormWallets
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(35)))), ((int)(((byte)(36)))), ((int)(((byte)(55)))));
            this.ClientSize = new System.Drawing.Size(384, 461);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.textBox_WalletBalance);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.textBox_WalletName);
            this.Controls.Add(this.button_DeleteWallet);
            this.Controls.Add(this.button_EnterWallet);
            this.Controls.Add(this.listBox_Wallets);
            this.Controls.Add(this.label_Greeting);
            this.Controls.Add(this.button_CreateWallet);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "FormWallets";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "My Wallets";
            this.Load += new System.EventHandler(this.WalletsForm_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button_CreateWallet;
        private System.Windows.Forms.Label label_Greeting;
        private System.Windows.Forms.ListBox listBox_Wallets;
        private System.Windows.Forms.Button button_EnterWallet;
        private System.Windows.Forms.Button button_DeleteWallet;
        private System.Windows.Forms.TextBox textBox_WalletName;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.TextBox textBox_WalletBalance;
    }
}

