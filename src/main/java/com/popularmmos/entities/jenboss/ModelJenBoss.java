package com.popularmmos.entities.jenboss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import thehippomaster.AnimationAPI.client.Animator;

/**
 * ModelBiped - TheMinecraftOverlord
 * Created using Tabula 4.1.1
 */
public class ModelJenBoss extends ModelBase {

    private Animator animator;

    public ModelRenderer Head;
    public ModelRenderer LArmA;
    public ModelRenderer RLegA;
    public ModelRenderer Chest;
    public ModelRenderer RArmA;
    public ModelRenderer LLegA;
    public ModelRenderer Circlet;
    public ModelRenderer CircletGem;
    public ModelRenderer LArmB;
    public ModelRenderer LShoulderpiece;
    public ModelRenderer GauntletBody;
    public ModelRenderer ThumbA;
    public ModelRenderer IndexFingA;
    public ModelRenderer MidFingA;
    public ModelRenderer RingFingA;
    public ModelRenderer PinkieA;
    public ModelRenderer MainGem;
    public ModelRenderer ThumbB;
    public ModelRenderer IndexFingB;
    public ModelRenderer IndexFingC;
    public ModelRenderer MidFingB;
    public ModelRenderer MidFingC;
    public ModelRenderer RingFingB;
    public ModelRenderer RingFingC;
    public ModelRenderer PinkieB;
    public ModelRenderer PinkieC;
    public ModelRenderer RLegB;
    public ModelRenderer RTopLeg;
    public ModelRenderer RBoot;
    public ModelRenderer RBottomLeg;
    public ModelRenderer Scabbard;
    public ModelRenderer Chestplate;
    public ModelRenderer RArmB;
    public ModelRenderer RShoulderpiece;
    public ModelRenderer LLegB;
    public ModelRenderer LTopLeg;
    public ModelRenderer LBoot;
    public ModelRenderer LBottomLeg;

    public ModelJenBoss() {
        this.textureWidth = 508;
        this.textureHeight = 508;
        this.IndexFingA = new ModelRenderer(this, 213, 192);
        this.IndexFingA.setRotationPoint(14.0F, 14.0F, -3.0F);
        this.IndexFingA.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.RTopLeg = new ModelRenderer(this, 70, 125);
        this.RTopLeg.setRotationPoint(-3.0F, 3.0F, 14.0F);
        this.RTopLeg.addBox(0.0F, -3.0F, -13.0F, 18, 25, 14, 0.0F);
        this.LLegB = new ModelRenderer(this, 0, 105);
        this.LLegB.setRotationPoint(0.0F, 24.0F, 0.1F);
        this.LLegB.addBox(-2.0F, 0.0F, -2.0F, 16, 24, 12, 0.0F);
        this.setRotateAngle(LLegB, 0.0F, 0.0F, -0.02897246558310587F);
        this.ThumbB = new ModelRenderer(this, 213, 200);
        this.ThumbB.setRotationPoint(0.0F, 3.8F, 0.0F);
        this.ThumbB.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(ThumbB, 0.2235766771804736F, 0.0F, 0.05305800926062762F);
        this.Chestplate = new ModelRenderer(this, 155, 103);
        this.Chestplate.setRotationPoint(-4.0F, -1.0F, 10.0F);
        this.Chestplate.addBox(-1.0F, 0.0F, -13.0F, 34, 49, 14, 0.0F);
        this.Circlet = new ModelRenderer(this, 1, 216);
        this.Circlet.setRotationPoint(-5.0F, 0.0F, -5.0F);
        this.Circlet.addBox(0.0F, -1.0F, 0.0F, 34, 3, 34, 0.0F);
        this.MidFingC = new ModelRenderer(this, 213, 183);
        this.MidFingC.setRotationPoint(0.0F, 3.4F, 0.0F);
        this.MidFingC.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(MidFingC, 0.2649409804527392F, 0.0F, 0.0F);
        this.GauntletBody = new ModelRenderer(this, 189, 225);
        this.GauntletBody.setRotationPoint(-4.0F, 4.0F, 0.0F);
        this.GauntletBody.addBox(0.0F, 0.0F, -3.0F, 18, 14, 14, 0.0F);
        this.LTopLeg = new ModelRenderer(this, 70, 125);
        this.LTopLeg.setRotationPoint(-3.0F, 3.0F, 10.0F);
        this.LTopLeg.addBox(0.0F, -3.0F, -13.0F, 18, 25, 14, 0.0F);
        this.Scabbard = new ModelRenderer(this, 2, 180);
        this.Scabbard.setRotationPoint(-6.0F, 32.5F, 11.0F);
        this.Scabbard.addBox(0.0F, -4.0F, 0.0F, 13, 50, 2, 0.0F);
        this.setRotateAngle(Scabbard, 0.0F, 0.0F, -2.0018926520374962F);
         this.RBoot = new ModelRenderer(this, 45, 183);
        this.RBoot.setRotationPoint(-3.0F, 21.0F, 13.0F);
        this.RBoot.addBox(0.0F, -13.0F, -13.0F, 19, 16, 16, 0.0F);
        this.RingFingA = new ModelRenderer(this, 213, 175);
        this.RingFingA.setRotationPoint(5.4F, 14.0F, -3.0F);
        this.RingFingA.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.IndexFingC = new ModelRenderer(this, 213, 192);
        this.IndexFingC.setRotationPoint(0.0F, 3.5F, 0.0F);
        this.IndexFingC.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(IndexFingC, 0.2649409804527392F, 0.0F, 0.0F);
        this.LArmB = new ModelRenderer(this, 198, 0);
        this.LArmB.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.LArmB.addBox(-3.0F, -2.0F, -2.0F, 16, 18, 12, 0.0F);
        this.LBoot = new ModelRenderer(this, 45, 183);
        this.LBoot.setRotationPoint(-4.0F, 21.0F, 9.0F);
        this.LBoot.addBox(0.0F, -13.0F, -13.0F, 19, 16, 16, 0.0F);
        this.ThumbA = new ModelRenderer(this, 213, 200);
        this.ThumbA.setRotationPoint(14.0F, 14.0F, 8.0F);
        this.ThumbA.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(ThumbA, 0.2235766771804736F, 0.0F, 0.05305800926062762F);
        this.RingFingB = new ModelRenderer(this, 213, 175);
        this.RingFingB.setRotationPoint(0.0F, 3.4F, 0.0F);
        this.RingFingB.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(RingFingB, 0.2649409804527392F, 0.0F, 0.0F);
        this.LArmA = new ModelRenderer(this, 160, 70);
        this.LArmA.setRotationPoint(-24.0F, -59.0F, 0.0F);
        this.LArmA.addBox(-3.0F, -2.0F, -2.0F, 16, 18, 12, 0.0F);
        this.setRotateAngle(LArmA, 0.0F, 0.0F, 0.10000736613927509F);
        this.RLegB = new ModelRenderer(this, 0, 105);
        this.RLegB.mirror = true;
        this.RLegB.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.RLegB.addBox(-2.0F, 0.0F, 2.0F, 16, 24, 12, 0.0F);
        this.setRotateAngle(RLegB, -0.0F, 0.0F, 0.02897246558310587F);
        this.Chest = new ModelRenderer(this, 64, 64);
        this.Chest.setRotationPoint(-7.0F, -60.0F, 0.0F);
        this.Chest.addBox(-4.0F, 0.0F, -2.0F, 32, 48, 12, 0.0F);
        this.LBottomLeg = new ModelRenderer(this, 104, 173);
        this.LBottomLeg.setRotationPoint(-3.0F, 3.0F, 10.0F);
        this.LBottomLeg.addBox(0.0F, -3.0F, -13.0F, 18, 8, 14, 0.0F);
        this.RingFingC = new ModelRenderer(this, 213, 175);
        this.RingFingC.setRotationPoint(0.0F, 3.4F, 0.0F);
        this.RingFingC.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(RingFingC, 0.2649409804527392F, 0.0F, 0.0F);
        this.RBottomLeg = new ModelRenderer(this, 104, 173);
        this.RBottomLeg.setRotationPoint(-3.0F, 3.0F, 14.0F);
        this.RBottomLeg.addBox(0.0F, -3.0F, -13.0F, 18, 8, 14, 0.0F);
         this.MainGem = new ModelRenderer(this, 206, 208);
        this.MainGem.setRotationPoint(11.0F, 2.0F, 2.0F);
        this.MainGem.addBox(0.0F, 0.0F, 0.0F, 7, 7, 7, 0.0F);
        this.setRotateAngle(MainGem, -0.7853981633974483F, 0.7853981633974483F, 0.7853981633974483F);
          this.PinkieA = new ModelRenderer(this, 215, 168);
        this.PinkieA.setRotationPoint(1.0F, 14.0F, -3.0F);
        this.PinkieA.addBox(1.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(PinkieA, 0.0017453292519943296F, 0.0F, -0.008377580409572781F);
        this.MidFingB = new ModelRenderer(this, 213, 183);
        this.MidFingB.setRotationPoint(0.0F, 4.0F, 0.1F);
        this.MidFingB.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(MidFingB, 0.2649409804527392F, 0.0F, 0.0F);
        this.CircletGem = new ModelRenderer(this, 8, 234);
        this.CircletGem.setRotationPoint(15.0F, 1.0F, -1.0F);
        this.CircletGem.addBox(0.0F, -3.0F, 0.0F, 4, 5, 1, 0.0F);
        this.RArmB = new ModelRenderer(this, 198, 0);
        this.RArmB.mirror = true;
        this.RArmB.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.RArmB.addBox(-1.0F, -2.0F, -2.0F, 16, 18, 12, 0.0F);
        this.IndexFingB = new ModelRenderer(this, 213, 192);
        this.IndexFingB.setRotationPoint(0.0F, 3.4F, 0.0F);
        this.IndexFingB.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(IndexFingB, 0.2649409804527392F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 61, 0);
        this.Head.setRotationPoint(-7.0F, -85.0F, -8.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 32, 32, 32, 0.5F);
        this.MidFingA = new ModelRenderer(this, 213, 183);
        this.MidFingA.setRotationPoint(9.7F, 14.0F, -3.0F);
        this.MidFingA.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.RShoulderpiece = new ModelRenderer(this, 0, 145);
        this.RShoulderpiece.setRotationPoint(-2.0F, 9.0F, 10.0F);
        this.RShoulderpiece.addBox(0.0F, -13.0F, -13.0F, 18, 14, 14, 0.0F);
        this.RArmA = new ModelRenderer(this, 160, 70);
        this.RArmA.mirror = true;
        this.RArmA.setRotationPoint(22.0F, -57.0F, 0.0F);
        this.RArmA.addBox(-1.0F, -2.0F, -2.0F, 16, 18, 12, 0.0F);
        this.setRotateAngle(RArmA, 0.0F, 0.0F, -0.10000736613927509F);
        this.LShoulderpiece = new ModelRenderer(this, 0, 145);
        this.LShoulderpiece.setRotationPoint(-4.0F, 9.0F, 10.0F);
        this.LShoulderpiece.addBox(0.0F, -13.0F, -13.0F, 18, 14, 14, 0.0F);
        this.PinkieC = new ModelRenderer(this, 215, 168);
        this.PinkieC.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.PinkieC.addBox(1.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(PinkieC, 0.2649409804527392F, 0.0F, 0.0F);
        this.PinkieB = new ModelRenderer(this, 215, 168);
        this.PinkieB.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.PinkieB.addBox(1.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(PinkieB, 0.2649409804527392F, 0.0F, 0.0F);
        this.RLegA = new ModelRenderer(this, 0, 64);
        this.RLegA.mirror = true;
        this.RLegA.setRotationPoint(6.9F, -12.0F, -3.9F);
        this.RLegA.addBox(-2.0F, 0.0F, 2.0F, 16, 24, 12, 0.0F);
        this.setRotateAngle(RLegA, -0.0F, 0.0F, -0.02897246558310587F);
        this.LLegA = new ModelRenderer(this, 0, 67);
        this.LLegA.setRotationPoint(-8.9F, -12.0F, 0.1F);
        this.LLegA.addBox(-2.0F, 0.0F, -2.0F, 16, 24, 12, 0.0F);
        this.setRotateAngle(LLegA, 0.0F, 0.0F, 0.02897246558310587F);
        this.GauntletBody.addChild(this.IndexFingA);
        this.RLegA.addChild(this.RTopLeg);
        this.LLegA.addChild(this.LLegB);
        this.ThumbA.addChild(this.ThumbB);
        this.Chest.addChild(this.Chestplate);
        this.Head.addChild(this.Circlet);
        this.MidFingB.addChild(this.MidFingC);
        this.LArmB.addChild(this.GauntletBody);
        this.LLegA.addChild(this.LTopLeg);
        this.Chest.addChild(this.Scabbard);
        this.RLegB.addChild(this.RBoot);
        this.GauntletBody.addChild(this.RingFingA);
        this.IndexFingB.addChild(this.IndexFingC);
        this.LArmA.addChild(this.LArmB);
        this.LLegB.addChild(this.LBoot);
        this.GauntletBody.addChild(this.ThumbA);
        this.RingFingA.addChild(this.RingFingB);
        this.RLegA.addChild(this.RLegB);
        this.LLegB.addChild(this.LBottomLeg);
        this.RingFingB.addChild(this.RingFingC);
        this.RLegB.addChild(this.RBottomLeg);
        this.GauntletBody.addChild(this.MainGem);
        this.GauntletBody.addChild(this.PinkieA);
        this.MidFingA.addChild(this.MidFingB);
        this.Circlet.addChild(this.CircletGem);
        this.RArmA.addChild(this.RArmB);
        this.IndexFingA.addChild(this.IndexFingB);
        this.GauntletBody.addChild(this.MidFingA);
        this.RArmA.addChild(this.RShoulderpiece);
        this.LArmA.addChild(this.LShoulderpiece);
        this.PinkieB.addChild(this.PinkieC);
        this.PinkieA.addChild(this.PinkieB);

        animator = new Animator(this);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        this.LArmA.render(f5);
        this.Chest.render(f5);
        this.Head.render(f5);
        this.RArmA.render(f5);
        this.RLegA.render(f5);
        this.LLegA.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        animator.update(entity);
        setAngles();

        //Sword Slice
        animator.setAnim(1);
        animator.startPhase(90);
            animator.rotate(RArmA, 0F, 1F, 0F);
        animator.endPhase();
        animator.setStationaryPhase(2);
        animator.resetPhase(1);
    }

    private void setAngles()
    {

    }

}
