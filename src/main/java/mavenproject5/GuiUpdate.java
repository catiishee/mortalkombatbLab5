package mavenproject5;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author user
 */
import java.awt.Rectangle;

public class GuiUpdate {

    private String label18Text;
    private String label2Text;
    private String dialogMessage;
    private String label3Text;
    private String label4Text;
    private String label5Text;
    private String label6Text;
    private String label26Text;
    private String label27Text;
    private String label29Text;
    private String fightEventOutput;
    private String label9Text;
    private String label10Text;
    private String label12Text;
    private String label13Text;
    private String label17Text;
    private String label16Text;
    private String label19Text;
    private String label24Text;
    private Integer humanHealth;
    private Integer enemyHealth;
    private Integer humanMaxHealth;
    private Integer enemyMaxHealth;
    private Integer pr1Value;
    private Integer pr2Value;
    private String rb1;
    private String rb2;
    private String rb3;
    private boolean showDialog;
    private boolean showDialog1;
    private boolean showDialog2;
    private boolean disposeFrame;
    private Rectangle dialogBounds;
    private Rectangle dialog1Bounds;
    private Rectangle dialog2Bounds;
    private boolean showDialog7;
    private String damageLabel;
    private String iconPath;
    private boolean disposeDialog1;

    // Getters and setters for all fields
    public void merge(GuiUpdate other) {
        if (other.label18Text != null) {
            this.label18Text = other.label18Text;
        }
        if (other.label2Text != null) {
            this.label2Text = other.label2Text;
        }
        if (other.dialogMessage != null) {
            this.dialogMessage = other.dialogMessage;
        }
        if (other.label3Text != null) {
            this.label3Text = other.label3Text;
        }
        if (other.label4Text != null) {
            this.label4Text = other.label4Text;
        }
        if (other.label5Text != null) {
            this.label5Text = other.label5Text;
        }
        if (other.label6Text != null) {
            this.label6Text = other.label6Text;
        }
        if (other.label26Text != null) {
            this.label26Text = other.label26Text;
        }
        if (other.label27Text != null) {
            this.label27Text = other.label27Text;
        }
        if (other.label29Text != null) {
            this.label29Text = other.label29Text;
        }
        if (other.fightEventOutput != null) {
            this.fightEventOutput = other.fightEventOutput;
        }
        if (other.label9Text != null) {
            this.label9Text = other.label9Text;
        }
        if (other.label10Text != null) {
            this.label10Text = other.label10Text;
        }
        if (other.label12Text != null) {
            this.label12Text = other.label12Text;
        }
        if (other.label13Text != null) {
            this.label13Text = other.label13Text;
        }
        if (other.label17Text != null) {
            this.label17Text = other.label17Text;
        }
        if (other.label16Text != null) {
            this.label16Text = other.label16Text;
        }
        if (other.label19Text != null) {
            this.label19Text = other.label19Text;
        }
        if (other.label24Text != null) {
            this.label24Text = other.label24Text;
        }
        if (other.humanHealth != null) {
            this.humanHealth = other.humanHealth;
        }
        if (other.enemyHealth != null) {
            this.enemyHealth = other.enemyHealth;
        }
        if (other.humanMaxHealth != null) {
            this.humanMaxHealth = other.humanMaxHealth;
        }
        if (other.enemyMaxHealth != null) {
            this.enemyMaxHealth = other.enemyMaxHealth;
        }
        if (other.pr1Value != null) {
            this.pr1Value = other.pr1Value;
        }
        if (other.pr2Value != null) {
            this.pr2Value = other.pr2Value;
        }
        if (other.rb1 != null) {
            this.rb1 = other.rb1;
        }
        if (other.rb2 != null) {
            this.rb2 = other.rb2;
        }
        if (other.rb3 != null) {
            this.rb3 = other.rb3;
        }
        this.showDialog = other.showDialog;
        this.showDialog1 = other.showDialog1;
        this.showDialog2 = other.showDialog2;
        this.disposeFrame = other.disposeFrame;
        if (other.dialogBounds != null) {
            this.dialogBounds = other.dialogBounds;
        }
        if (other.dialog1Bounds != null) {
            this.dialog1Bounds = other.dialog1Bounds;
        }
        if (other.dialog2Bounds != null) {
            this.dialog2Bounds = other.dialog2Bounds;
        }
        this.showDialog7 = other.showDialog7;
        if (other.damageLabel != null) {
            this.damageLabel = other.damageLabel;
        }
        if (other.iconPath != null) {
            this.iconPath = other.iconPath;
        }
        this.disposeDialog1 = other.disposeDialog1;
    }

    public String getLabel18Text() {
        return label18Text;
    }

    public void setLabel18Text(String label18Text) {
        this.label18Text = label18Text;
    }

    public String getLabel2Text() {
        return label2Text;
    }

    public void setLabel2Text(String label2Text) {
        this.label2Text = label2Text;
    }

    public String getDialogMessage() {
        return dialogMessage;
    }

    public void setDialogMessage(String dialogMessage) {
        this.dialogMessage = dialogMessage;
    }

    public String getLabel3Text() {
        return label3Text;
    }

    public void setLabel3Text(String label3Text) {
        this.label3Text = label3Text;
    }

    public String getLabel4Text() {
        return label4Text;
    }

    public void setLabel4Text(String label4Text) {
        this.label4Text = label4Text;
    }

    public String getLabel5Text() {
        return label5Text;
    }

    public void setLabel5Text(String label5Text) {
        this.label5Text = label5Text;
    }

    public String getLabel6Text() {
        return label6Text;
    }

    public void setLabel6Text(String label6Text) {
        this.label6Text = label6Text;
    }

    public String getLabel26Text() {
        return label26Text;
    }

    public void setLabel26Text(String label26Text) {
        this.label26Text = label26Text;
    }

    public String getLabel27Text() {
        return label27Text;
    }

    public void setLabel27Text(String label27Text) {
        this.label27Text = label27Text;
    }

    public String getLabel29Text() {
        return label29Text;
    }

    public void setLabel29Text(String label29Text) {
        this.label29Text = label29Text;
    }

    public String getFightEventOutput() {
        return fightEventOutput;
    }

    public void setFightEventOutput(String fightEventOutput) {
        this.fightEventOutput = fightEventOutput;
    }

    public String getLabel9Text() {
        return label9Text;
    }

    public void setLabel9Text(String label9Text) {
        this.label9Text = label9Text;
    }

    public String getLabel10Text() {
        return label10Text;
    }

    public void setLabel10Text(String label10Text) {
        this.label10Text = label10Text;
    }

    public String getLabel12Text() {
        return label12Text;
    }

    public void setLabel12Text(String label12Text) {
        this.label12Text = label12Text;
    }

    public String getLabel13Text() {
        return label13Text;
    }

    public void setLabel13Text(String label13Text) {
        this.label13Text = label13Text;
    }

    public String getLabel17Text() {
        return label17Text;
    }

    public void setLabel17Text(String label17Text) {
        this.label17Text = label17Text;
    }

    public String getLabel16Text() {
        return label16Text;
    }

    public void setLabel16Text(String label16Text) {
        this.label16Text = label16Text;
    }

    public String getLabel19Text() {
        return label19Text;
    }

    public void setLabel19Text(String label19Text) {
        this.label19Text = label19Text;
    }

    public String getLabel24Text() {
        return label24Text;
    }

    public void setLabel24Text(String label24Text) {
        this.label24Text = label24Text;
    }

    public Integer getHumanHealth() {
        return humanHealth;
    }

    public void setHumanHealth(Integer humanHealth) {
        this.humanHealth = humanHealth;
    }

    public Integer getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(Integer enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public Integer getHumanMaxHealth() {
        return humanMaxHealth;
    }

    public void setHumanMaxHealth(Integer humanMaxHealth) {
        this.humanMaxHealth = humanMaxHealth;
    }

    public Integer getEnemyMaxHealth() {
        return enemyMaxHealth;
    }

    public void setEnemyMaxHealth(Integer enemyMaxHealth) {
        this.enemyMaxHealth = enemyMaxHealth;
    }

    public Integer getPr1Value() {
        return pr1Value;
    }

    public void setPr1Value(Integer pr1Value) {
        this.pr1Value = pr1Value;
    }

    public Integer getPr2Value() {
        return pr2Value;
    }

    public void setPr2Value(Integer pr2Value) {
        this.pr2Value = pr2Value;
    }

    public String getRb1() {
        return rb1;
    }

    public void setRb1(String rb1) {
        this.rb1 = rb1;
    }

    public String getRb2() {
        return rb2;
    }

    public void setRb2(String rb2) {
        this.rb2 = rb2;
    }

    public String getRb3() {
        return rb3;
    }

    public void setRb3(String rb3) {
        this.rb3 = rb3;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }

    public boolean isShowDialog1() {
        return showDialog1;
    }

    public void setShowDialog1(boolean showDialog1) {
        this.showDialog1 = showDialog1;
    }

    public boolean isShowDialog2() {
        return showDialog2;
    }

    public void setShowDialog2(boolean showDialog2) {
        this.showDialog2 = showDialog2;
    }

    public boolean isDisposeFrame() {
        return disposeFrame;
    }

    public void setDisposeFrame(boolean disposeFrame) {
        this.disposeFrame = disposeFrame;
    }

    public Rectangle getDialogBounds() {
        return dialogBounds;
    }

    public void setDialogBounds(Rectangle dialogBounds) {
        this.dialogBounds = dialogBounds;
    }

    public Rectangle getDialog1Bounds() {
        return dialog1Bounds;
    }

    public void setDialog1Bounds(Rectangle dialog1Bounds) {
        this.dialog1Bounds = dialog1Bounds;
    }

    public Rectangle getDialog2Bounds() {
        return dialog2Bounds;
    }

    public void setDialog2Bounds(Rectangle dialog2Bounds) {
        this.dialog2Bounds = dialog2Bounds;
    }

    public boolean isShowDialog7() {
        return showDialog7;
    }

    public void setShowDialog7(boolean showDialog7) {
        this.showDialog7 = showDialog7;
    }

    public String getDamageLabel() {
        return damageLabel;
    }

    public void setDamageLabel(String damageLabel) {
        this.damageLabel = damageLabel;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public boolean isDisposeDialog1() {
        return disposeDialog1;
    }

    public void setDisposeDialog1(boolean disposeDialog1) {
        this.disposeDialog1 = disposeDialog1;
    }

   
}
