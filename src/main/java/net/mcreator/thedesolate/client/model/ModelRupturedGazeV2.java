package net.mcreator.thedesolate.client.model;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelRupturedGazeV2 extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath("the_desolate", "model_ruptured_gaze_v_2"), "main");
	public final ModelPart bone;
	public final ModelPart right_leg;
	public final ModelPart right_arm;
	public final ModelPart left_arm;
	public final ModelPart left_leg;
	public final ModelPart head;
	public final ModelPart torso;

	public ModelRupturedGazeV2(ModelPart root) {
		super(root);
		this.bone = root.getChild("bone");
		this.right_leg = this.bone.getChild("right_leg");
		this.right_arm = this.bone.getChild("right_arm");
		this.left_arm = this.bone.getChild("left_arm");
		this.left_leg = this.bone.getChild("left_leg");
		this.head = this.bone.getChild("head");
		this.torso = this.bone.getChild("torso");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 8.0F, -2.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition right_leg = bone.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition right_leg_r1 = right_leg.addOrReplaceChild("right_leg_r1", CubeListBuilder.create().texOffs(34, 22).addBox(-3.0197F, -2.0001F, -1.056F, 3.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0035F, -0.014F, -0.0012F));
		PartDefinition right_arm = bone.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(22, 16).addBox(-3.0F, -2.0F, -2.0F, 3.0F, 19.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, -2.0F));
		PartDefinition left_arm = bone.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(34, 0).addBox(-3.0F, -2.0F, -1.0F, 3.0F, 19.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 6.0F));
		PartDefinition left_leg = bone.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 35).addBox(-3.0F, -2.0F, -2.0F, 3.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.0F));
		PartDefinition head = bone.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -4.0F, 7.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -16.0F, 2.0F));
		PartDefinition torso = bone.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(2, 18).addBox(-3.0F, -5.0F, -3.0F, 3.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 2.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public void setupAnim(LivingEntityRenderState state) {
		float limbSwing = state.walkAnimationPos;
		float limbSwingAmount = state.walkAnimationSpeed;
		float ageInTicks = state.ageInTicks;
		float netHeadYaw = state.yRot;
		float headPitch = state.xRot;

	}

}