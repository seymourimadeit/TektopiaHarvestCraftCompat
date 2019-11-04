package tallestegg.TektopiaImproved;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;

import com.pam.harvestcraft.blocks.CropRegistry;
import com.pam.harvestcraft.item.ItemRegistry;
import com.typesafe.config.ConfigException.Null;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.tangotek.tektopia.entities.ai.EntityAIEatFood;

public final class FoodHelper {
    private FoodHelper() {}

    private static final Method REGISTER_FOOD;

    static {
        try {
            REGISTER_FOOD = EntityAIEatFood.class.getDeclaredMethod("registerFood", Item.class, int.class, int.class);
            REGISTER_FOOD.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }        
    public static void register(Item item, int hunger, int happy) {
        try {
            REGISTER_FOOD.invoke(null, item, hunger, happy);
         } catch (IllegalAccessException | InvocationTargetException e) {
                 throw new RuntimeException(e);
    
        }
    }

		
	}

		
	

		
	



