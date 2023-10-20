import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CraftInventoryChatGPTUpdate {
    private static String[] inventoryWeapons = {"DesertEagle", "Bat", "Katana"};
    private static String[] heroes = {"Adolf", "Yaroslav", "Sofia", "Tolubko", "Pidpaluy"};

    private static JComboBox<String> heroComboBox;
    private static JCheckBox multiCraftCheckBox;
    private static JButton chooseWeaponsButton;
    private static JButton craftButton;

    private static String selectedHero;
    private static String firstSelectedWeapon;
    private static String secondSelectedWeapon;

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

        chooseWeaponsButton = new JButton("Choose Weapons");
        chooseWeaponsButton.addActionListener(new ChooseWeaponsButtonListener());
        panel.add(chooseWeaponsButton);

        craftButton = new JButton("Craft");
        craftButton.addActionListener(new CraftButtonListener());
        panel.add(craftButton);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }

    private static class ChooseWeaponsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectedHero = (String) heroComboBox.getSelectedItem();

            // Open a new window to choose weapons
            openChooseWeaponsWindow();
        }
    }

    private static void openChooseWeaponsWindow() {
        JFrame weaponsFrame = new JFrame("Choose Weapons");
        weaponsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        weaponsFrame.setSize(300, 150);

        JPanel weaponsPanel = new JPanel();
        weaponsPanel.setLayout(new GridLayout(4, 2));

        JComboBox<String> firstWeaponComboBox = new JComboBox<>(inventoryWeapons);
        JComboBox<String> secondWeaponComboBox = new JComboBox<>(inventoryWeapons);

        weaponsPanel.add(new JLabel("Select First Weapon:"));
        weaponsPanel.add(firstWeaponComboBox);

        weaponsPanel.add(new JLabel("Select Second Weapon:"));
        weaponsPanel.add(secondWeaponComboBox);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Save the selected weapons and close the window
                firstSelectedWeapon = (String) firstWeaponComboBox.getSelectedItem();
                secondSelectedWeapon = (String) secondWeaponComboBox.getSelectedItem();

                // Check if any weapon is null
                if (firstSelectedWeapon == null || secondSelectedWeapon == null) {
                    JOptionPane.showMessageDialog(null, "Please select both weapons.", "Selection Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    weaponsFrame.dispose();
                }
            }
        });
        weaponsPanel.add(confirmButton);

        weaponsFrame.getContentPane().add(BorderLayout.CENTER, weaponsPanel);
        weaponsFrame.setVisible(true);
    }

    private static class CraftButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean multiCraft = multiCraftCheckBox.isSelected();

            if (multiCraft) {
                // Display a new window with additional information for multi-crafting
                displayMultiCraftingWindow(selectedHero, firstSelectedWeapon, secondSelectedWeapon);
            } else {
                // Craft and show the result in a JOptionPane
                String craftingResult = craft(selectedHero, multiCraft, firstSelectedWeapon);
                JOptionPane.showMessageDialog(null, craftingResult, "Crafting Result", JOptionPane.INFORMATION_MESSAGE);

                // Simulate a fight based on the hero and crafted item
                simulateFight(selectedHero, firstSelectedWeapon);
            }
        }
    }

    private static void displayMultiCraftingWindow(String selectedHero, String firstWeapon, String secondWeapon) {
        JFrame multiCraftFrame = new JFrame("Multi-Crafting Window");
        multiCraftFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        multiCraftFrame.setSize(300, 150);

        JPanel multiCraftPanel = new JPanel();
        multiCraftPanel.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Multi-Crafting Information for " + selectedHero);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        multiCraftPanel.add(titleLabel);

        JLabel weaponsLabel = new JLabel("Selected Weapons: " + firstWeapon + " and " + secondWeapon);
        weaponsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        multiCraftPanel.add(weaponsLabel);

        JLabel infoLabel = new JLabel("Additional information for multi-crafting goes here.");
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        multiCraftPanel.add(infoLabel);

        multiCraftFrame.getContentPane().add(BorderLayout.CENTER, multiCraftPanel);
        multiCraftFrame.setVisible(true);

        // Simulate a fight based on the hero and crafted items
        simulateFight(selectedHero, firstWeapon);
    }

    private static void simulateFight(String selectedHero, String selectedWeapon) {
        // Simulate a fight scenario based on the hero and crafted item
        JFrame fightFrame = new JFrame("Fight Scenario");
        fightFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fightFrame.setSize(300, 150);

        JPanel fightPanel = new JPanel();
        fightPanel.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Fight Scenario for " + selectedHero);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fightPanel.add(titleLabel);

        JLabel weaponLabel = new JLabel("Selected Weapon: " + selectedWeapon);
        weaponLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fightPanel.add(weaponLabel);

        JLabel fightResultLabel;
        if ("Sofia".equalsIgnoreCase(selectedHero)) {
            // Special scenario for Sofia
            fightResultLabel = new JLabel("Sofia is the strongest with all weapons. Win!");
        } else {
            // Generic fight scenario
            fightResultLabel = new JLabel("The result of the fight remains a mystery...");
        }
        fightResultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fightPanel.add(fightResultLabel);

        fightFrame.getContentPane().add(BorderLayout.CENTER, fightPanel);
        fightFrame.setVisible(true);
    }

    private static String craft(String selectedHero, boolean multiCraft, String selectedWeapon) {
        // ... (unchanged code for crafting)
        return "Crafting scenario for " + selectedHero + ":\n" +
                selectedHero + " crafted: " + selectedWeapon;
    }
}
