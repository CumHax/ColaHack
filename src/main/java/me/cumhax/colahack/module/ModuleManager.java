package me.cumhax.colahack.module;

import java.util.ArrayList;
import java.util.stream.Collectors;
import me.cumhax.colahack.Client;
import me.cumhax.colahack.gui.hud.component.*;
import me.cumhax.colahack.module.Category;
import me.cumhax.colahack.module.Module;
import me.cumhax.colahack.module.combat.*;
import me.cumhax.colahack.module.exploit.*;
import me.cumhax.colahack.module.movement.*;
import me.cumhax.colahack.module.render.*;
import me.cumhax.colahack.module.misc.*;
import me.cumhax.colahack.module.hud.*;

public class ModuleManager {
    private static final ArrayList<Module> modules = new ArrayList();

    public ModuleManager() {
//Combat
this.modules.add(new Aura());
this.modules.add(new AutoArmor());
this.modules.add(new AutoCrystal());
this.modules.add(new AutoTotem());
this.modules.add(new AutoTrap());
this.modules.add(new BowSpam());
this.modules.add(new Criticals());
this.modules.add(new HoleFiller());
this.modules.add(new Offhand());
this.modules.add(new PistonCrystal());
this.modules.add(new Surround());


//Exploit
this.modules.add(new AuthBypass());
this.modules.add(new BallzDuup());
this.modules.add(new BoatPlaceBypass());
this.modules.add(new DonkeyDupe());
this.modules.add(new EntityVanish());
this.modules.add(new HasteExploit());
this.modules.add(new MultiTask());
this.modules.add(new NoEntityTrace());
this.modules.add(new PacketCanceller());
this.modules.add(new PosDesync());
this.modules.add(new Burrow());


//Hud
this.modules.add(new ArmorHud());
this.modules.add(new CulWatermark());


//Misc
this.modules.add(new Blink());
this.modules.add(new ChatSuffix());
this.modules.add(new RichPresence());
this.modules.add(new FakePlayer());
this.modules.add(new GuiMove());
this.modules.add(new Notify());
this.modules.add(new MiddleClick());
this.modules.add(new PacketSwing());


//Movement
this.modules.add(new Anchor());
this.modules.add(new AntiVoid());
this.modules.add(new AutoWalk());
this.modules.add(new LongJump());
this.modules.add(new NoSlow());
this.modules.add(new ReverseStep());
this.modules.add(new Step());
this.modules.add(new Strafe());
this.modules.add(new Velocity());


//Render
this.modules.add(new BlockHighlight());
this.modules.add(new Chams());
this.modules.add(new ClickGUI());
this.modules.add(new CustomFont());
this.modules.add(new FullBright());
this.modules.add(new HoleESP());
//this.modules.add(new HUDEditor());
this.modules.add(new ItemViewmodle());
this.modules.add(new ShulkerViewer());
this.modules.add(new VoidESP());

    }

    public static void onUpdate () {
        Client.moduleManager.getModules ( ).stream ( ).filter ( Module::isEnabled ).forEach ( Module::onUpdate );
    }

    public ArrayList<Module> getModules () {
        return this.modules;
    }

    public Module getModule ( String name ) {
        for (Module module : this.modules) {
            if ( !module.getName ( ).equalsIgnoreCase ( name ) ) continue;
            return module;
        }
        return null;
    }

    public ArrayList<Module> getModules ( Category category ) {
        ArrayList<Module> mods=new ArrayList<Module> ( );
        for (Module module : this.modules) {
            if ( !module.getCategory ( ).equals ( (Object) category ) ) continue;
            mods.add ( module );
        }
        return mods;
    }

    public ArrayList<Module> getEnabledModules () {
        return this.modules.stream ( ).filter ( Module::isEnabled ).collect ( Collectors.toCollection ( ArrayList::new ) );
    }

    public static Module getModuleByName ( String name ) {
        return modules.stream ( ).filter ( module -> module.getName ( ).equalsIgnoreCase ( name ) ).findFirst ( ).orElse ( null );
    }

    public static Module getModuleByClass ( Class<?> clazz ) {
        return modules.stream ( ).filter ( module -> module.getClass ( ).equals ( clazz ) ).findFirst ( ).orElse ( null );
    }
}
