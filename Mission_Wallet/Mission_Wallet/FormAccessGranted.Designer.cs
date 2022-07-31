
namespace Mission_Wallet
{
    partial class FormAccessGranted
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormAccessGranted));
            this.btn_E = new System.Windows.Forms.Button();
            this.btn_I = new System.Windows.Forms.Button();
            this.btn_D = new System.Windows.Forms.Button();
            this.label_Report = new System.Windows.Forms.Label();
            this.label_WalletName = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btn_E
            // 
            this.btn_E.BackColor = System.Drawing.Color.Cyan;
            this.btn_E.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btn_E.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_E.Location = new System.Drawing.Point(50, 94);
            this.btn_E.Margin = new System.Windows.Forms.Padding(2);
            this.btn_E.Name = "btn_E";
            this.btn_E.Size = new System.Drawing.Size(100, 50);
            this.btn_E.TabIndex = 0;
            this.btn_E.Text = "Expences";
            this.btn_E.UseVisualStyleBackColor = false;
            this.btn_E.Click += new System.EventHandler(this.btn_E_Click);
            // 
            // btn_I
            // 
            this.btn_I.BackColor = System.Drawing.Color.Cyan;
            this.btn_I.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btn_I.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_I.Location = new System.Drawing.Point(210, 94);
            this.btn_I.Margin = new System.Windows.Forms.Padding(2);
            this.btn_I.Name = "btn_I";
            this.btn_I.Size = new System.Drawing.Size(100, 50);
            this.btn_I.TabIndex = 0;
            this.btn_I.Text = "Income";
            this.btn_I.UseVisualStyleBackColor = false;
            this.btn_I.Click += new System.EventHandler(this.btn_I_Click);
            // 
            // btn_D
            // 
            this.btn_D.BackColor = System.Drawing.Color.Cyan;
            this.btn_D.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btn_D.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_D.Location = new System.Drawing.Point(378, 94);
            this.btn_D.Margin = new System.Windows.Forms.Padding(2);
            this.btn_D.Name = "btn_D";
            this.btn_D.Size = new System.Drawing.Size(100, 50);
            this.btn_D.TabIndex = 0;
            this.btn_D.Text = "Debit";
            this.btn_D.UseVisualStyleBackColor = false;
            this.btn_D.Click += new System.EventHandler(this.btn_D_Click);
            // 
            // label_Report
            // 
            this.label_Report.AutoSize = true;
            this.label_Report.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(35)))), ((int)(((byte)(36)))), ((int)(((byte)(55)))));
            this.label_Report.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label_Report.ForeColor = System.Drawing.SystemColors.Control;
            this.label_Report.Location = new System.Drawing.Point(222, 209);
            this.label_Report.Name = "label_Report";
            this.label_Report.Size = new System.Drawing.Size(88, 17);
            this.label_Report.TabIndex = 2;
            this.label_Report.Text = "Full Report";
            this.label_Report.Click += new System.EventHandler(this.label_Report_Click);
            // 
            // label_WalletName
            // 
            this.label_WalletName.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.label_WalletName.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label_WalletName.ForeColor = System.Drawing.Color.White;
            this.label_WalletName.Location = new System.Drawing.Point(12, 28);
            this.label_WalletName.Name = "label_WalletName";
            this.label_WalletName.Size = new System.Drawing.Size(506, 31);
            this.label_WalletName.TabIndex = 3;
            this.label_WalletName.Text = "Wallet";
            this.label_WalletName.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // FormAccessGranted
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(35)))), ((int)(((byte)(36)))), ((int)(((byte)(55)))));
            this.ClientSize = new System.Drawing.Size(530, 277);
            this.Controls.Add(this.label_WalletName);
            this.Controls.Add(this.label_Report);
            this.Controls.Add(this.btn_D);
            this.Controls.Add(this.btn_I);
            this.Controls.Add(this.btn_E);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "FormAccessGranted";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Home";
            this.Load += new System.EventHandler(this.AccessGrantedForm_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btn_E;
        private System.Windows.Forms.Button btn_I;
        private System.Windows.Forms.Button btn_D;
        private System.Windows.Forms.Label label_Report;
        private System.Windows.Forms.Label label_WalletName;
    }
}