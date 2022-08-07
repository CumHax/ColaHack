package me.cumhax.colahack.module.misc;

import me.cumhax.colahack.module.Category;
import me.cumhax.colahack.module.Module;
import me.cumhax.colahack.util.LoggerUtil;
import java.util.Arrays;
import java.util.Iterator;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatSuffix extends Module {

   public ChatSuffix()
   {
      super("ChatSuffix", "", Category.MISC);
   }
   @SubscribeEvent
   public void onChat(ClientChatEvent event) {
      Iterator var2 = Arrays.asList("/", ".", "-", ",", ":", ";", "'", "\"", "+", "\\").iterator();

      String s;
      do {
         if (!var2.hasNext()) {
            event.setMessage(event.getMessage() + " ｜ ColaHack.eu");
            return;
         }

         s = (String)var2.next();
      } while(!event.getMessage().startsWith(s));
   }
}
