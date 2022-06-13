package fr.antique.hg.chest;

import com.avaje.ebean.validation.NotNull;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;

import javax.xml.namespace.NamespaceContext;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LootItem {
    private final Material material;
    private final String customName;
    private final Map<Enchantment, Integer> enchantmentToLevelMap = new HashMap<>();
    private final double chance;
    private final int minAmount;
    private final int maxAmount;

    public LootItem(ConfigurationSection section) {

        Material material;

        try {
            material = Material.valueOf(section.getString("material"));
        } catch (Exception e) {
            material = Material.AIR;
        }

        this.material = material;
        this.customName = section.getString("name");

        ConfigurationSection enchantmentsSection = section.getConfigurationSection("enchantments");
        if (enchantmentsSection != null) {
            for (String enchantmentKey : enchantmentsSection.getKeys(false)) {
                Enchantment enchantment = Enchantment.getByName(Name.minecraft(enchantmentKey.toLowerCase()));
            }
        }
    }
}
