package com.popularmmos.items.largeWeight;

import com.popularmmos.entities.pat.largeweight.ModelLargeWeight;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderItemLargeWeight implements IItemRenderer{

    private ModelLargeWeight modelWeight;

    public static ResourceLocation texture = new ResourceLocation("popular:textures/models/largeWeight.png");

    public RenderItemLargeWeight()
    {
        modelWeight = new ModelLargeWeight();

    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch(type)
        {
            case EQUIPPED: return true;
            case EQUIPPED_FIRST_PERSON: return true;
            case ENTITY: return true;
            default: return false;

        }

    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        switch(type)
        {
            case EQUIPPED:
            {
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);

                GL11.glRotatef(120F, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-.4F, -1.5F, 0F);

                this.modelWeight.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, .0650F);

                GL11.glPopMatrix();
                break;
            }

            case EQUIPPED_FIRST_PERSON:
            {

                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);

                GL11.glRotatef(120F, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-.4F, -1.5F, 0F);

                boolean isFirstPerson = false;

                if(data[1] != null && data[1] instanceof EntityPlayer)
                {
                    if(!((EntityPlayer)data[1] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && !((Minecraft.getMinecraft().currentScreen instanceof GuiInventory || Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative) && RenderManager.instance.playerViewY == 180.0F)))
                    {
                        //    GL11.glTranslatef(-.6F, -.4F, 0F);
                    }
                    else
                    {
                        isFirstPerson = true;
                        //  GL11.glTranslatef(-.6F, -.4F, 0F);

                    }
                }
                else
                {
                    GL11.glTranslatef(-.4F, -1.5F, 0F);
                    GL11.glRotatef(90F, 0F, 0F, 1F);
                }

                this.modelWeight.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0650F);
                GL11.glPopMatrix();
                break;
            }

            case ENTITY:
            {
                GL11.glPushMatrix();

                Minecraft.getMinecraft().renderEngine.bindTexture(texture);

                GL11.glRotatef(180F, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-.8F, -1.55F, 0F);

                this.modelWeight.render(0.0750F);

                GL11.glPopMatrix();
                break;
            }

            default:
                break;
        }
    }
}
