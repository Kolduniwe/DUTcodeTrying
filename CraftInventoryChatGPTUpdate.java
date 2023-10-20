import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CraftInventoryChatGPTUpdate {
    private static String[] inventoryWeapons = {"DesertEagle", "Bat", "Katana"};
    private static String[] heroes = {"Adolf", "Yaroslav", "Sofia", "Tolubko", "Pidpaluy"};

    private static JComboBox<String> heroComboBox;
    private static JCheckBox multiCraftCheckBox;
    private static JComboBox<String> weaponComboBox;
    private static JButton craftButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Crafting Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Select Hero:"));
        heroComboBox = new JComboBox<>(heroes);
        panel.add(heroComboBox);

        panel.add(new JLabel("Craft using multiple weapons?"));
        multiCraftCheckBox = new JCheckBox();
        panel.add(multiCraftCheckBox);

        panel.add(new JLabel("Select Weapon:"));
        weaponComboBox = new JComboBox<>(inventoryWeapons);
        panel.add(weaponComboBox);

        craftButton = new JButton("Craft");
        craftButton.addActionListener(new CraftButtonListener());
        panel.add(craftButton);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }

    private static class CraftButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedHero = (String) heroComboBox.getSelectedItem();
            boolean multiCraft = multiCraftCheckBox.isSelected();
            String selectedWeapon = (String) weaponComboBox.getSelectedItem();

            String craftingResult = craft(selectedHero, multiCraft, selectedWeapon);

            JOptionPane.showMessageDialog(null, craftingResult, "Crafting Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static String craft(String selectedHero, boolean multiCraft, String selectedWeapon) {
        StringBuilder result = new StringBuilder("Crafting scenario for " + selectedHero + ":\n");

        if (multiCraft) {
            // Implement multi-crafting scenario
            // You can add logic for combining weapons here
            result.append("Multi-crafting is not implemented yet. Crafted: ").append(selectedWeapon);
        } else {
            // Implement single-crafting scenario
            switch (selectedHero.toLowerCase()) {
                case "tolubko":
                    result.append("Tolubko crafted: Legendary Tolubko's ").append(selectedWeapon).append("!");
                    break;
                case "pidpaluy":
                    result.append("Pidpaluy crafted: Enchanted ").append(selectedWeapon).append(" of Pidpaluy!");
                    break;
                case "sofia":
                    result.append("Sofia crafted something unique with ").append(selectedWeapon).append("!");
                    break;
                default:
                    result.append(selectedHero).append(" crafted: Epic ").append(selectedWeapon).append("!");
                    break;
            }
        }

        // Simulate a fight based on the hero and crafted item
        if (!selectedHero.equalsIgnoreCase("sofia")) {
            result.append("\nEntering a fight...\n").append(selectedHero).append(" fights valiantly with ")
                    .append(selectedWeapon).append(". The outcome is uncertain. Good luck!");
        } else {
            result.append("\nSofia wins the fight!");
        }

        return result.toString();
    }
}