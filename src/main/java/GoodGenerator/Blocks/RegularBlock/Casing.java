package GoodGenerator.Blocks.RegularBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.GregTech_API;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Casing extends Block {

    @SideOnly(Side.CLIENT)
    protected IIcon[] texture;
    String[] textureNames;
    protected String name;

    public Casing(String name, String[] texture, CreativeTabs Tab){
        super(Material.iron);
        this.setHardness(18.0F);
        this.setResistance(10.0F);
        this.name = name;
        this.textureNames = texture;
        GregTech_API.registerMachineBlock(this, -1);
    }

    public Casing(String name, String[] texture, CreativeTabs Tab,Material material){
        super(material);
        this.setHardness(18.0F);
        this.setResistance(10.0F);
        this.name = name;
        this.textureNames = texture;
        GregTech_API.registerMachineBlock(this, -1);
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return meta < this.texture.length ? this.texture[meta] : this.texture[0];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.texture = new IIcon[this.textureNames.length];
        for (int i = 0; i < this.textureNames.length; i++) {
            this.texture[i] = par1IconRegister.registerIcon(this.textureNames[i]);
        }
    }

    @Override
    public void onBlockAdded(World aWorld, int aX, int aY, int aZ) {
        if (GregTech_API.isMachineBlock(this, aWorld.getBlockMetadata(aX, aY, aZ))) {
            GregTech_API.causeMachineUpdate(aWorld, aX, aY, aZ);
        }
    }

    @Override
    public void breakBlock(World aWorld, int aX, int aY, int aZ, Block aBlock, int aMetaData) {
        if (GregTech_API.isMachineBlock(this, aWorld.getBlockMetadata(aX, aY, aZ))) {
            GregTech_API.causeMachineUpdate(aWorld, aX, aY, aZ);
        }
    }

    @Override
    public String getUnlocalizedName() {
        return this.name;
    }

    @Override
    public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z) {
        return false;
    }

    @Override
    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
        return false;
    }

    @Override
    public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z) {
        return false;
    }


}
