package com.github.technus.tectech.thing.metaTileEntity.hatch.gui;

import com.github.technus.tectech.TecTech;
import com.github.technus.tectech.util.Util;
import com.github.technus.tectech.thing.metaTileEntity.hatch.GT_MetaTileEntity_Hatch_Param;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.gui.GT_ContainerMetaTile_Machine;
import gregtech.api.gui.GT_Slot_Holo;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class GT_Container_Param extends GT_ContainerMetaTile_Machine {
    public int param = 0;
    public double value0d = 0;
    public double value1d = 0;
    public double input0d = 0;
    public double input1d = 0;
    public long value0l = 0;
    public long value1l = 0;
    public long input0l = 0;
    public long input1l = 0;

    public GT_Container_Param(InventoryPlayer aInventoryPlayer, IGregTechTileEntity aTileEntity) {
        super(aInventoryPlayer, aTileEntity);
    }

    @Override
    public void addSlots(InventoryPlayer aInventoryPlayer) {
        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 8, 5, false, false, 1));
        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 8, 23, false, false, 1));
        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 8, 41, false, false, 1));
        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 8, 59, false, false, 1));

        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 26, 5, false, false, 1));
        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 26, 23, false, false, 1));
        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 26, 41, false, false, 1));
        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 26, 59, false, false, 1));

        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 152, 5, false, false, 1));
        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 152, 23, false, false, 1));
        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 152, 41, false, false, 1));
        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 152, 59, false, false, 1));

        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 134, 5, false, false, 1));
        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 134, 23, false, false, 1));
        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 134, 41, false, false, 1));
        addSlotToContainer(new GT_Slot_Holo(mTileEntity, 2, 134, 59, false, false, 1));
    }

    @Override
    public ItemStack slotClick(int aSlotIndex, int aMouseclick, int aShifthold, EntityPlayer aPlayer) {
        if (aSlotIndex < 0) {
            return super.slotClick(aSlotIndex, aMouseclick, aShifthold, aPlayer);
        }
        Slot tSlot = (Slot) inventorySlots.get(aSlotIndex);
        boolean doStuff = true;
        if (tSlot != null && mTileEntity.getMetaTileEntity() != null) {
            GT_MetaTileEntity_Hatch_Param paramH = (GT_MetaTileEntity_Hatch_Param) mTileEntity.getMetaTileEntity();
            switch (aSlotIndex) {
                case 0:
                    paramH.param -= aShifthold == 1 ? 16 : 4;
                    break;
                case 1:
                    paramH.value0D -= aShifthold == 1 ? 4096 : 256;
                    break;
                case 2:
                    paramH.value1D -= aShifthold == 1 ? 4096 : 256;
                    break;
                case 3:
                    paramH.value0D /= aShifthold == 1 ? 4096 : 256;
                    paramH.value1D /= aShifthold == 1 ? 4096 : 256;
                    break;
                case 4:
                    paramH.param -= aShifthold == 1 ? 2 : 1;
                    break;
                case 5:
                    paramH.value0D -= aShifthold == 1 ? 16 : 1;
                    break;
                case 6:
                    paramH.value1D -= aShifthold == 1 ? 16 : 1;
                    break;
                case 7:
                    paramH.value0D /= aShifthold == 1 ? 16 : 2;
                    paramH.value1D /= aShifthold == 1 ? 16 : 2;
                    break;
                case 8:
                    paramH.param += aShifthold == 1 ? 16 : 4;
                    break;
                case 9:
                    paramH.value0D += aShifthold == 1 ? 4096 : 256;
                    break;
                case 10:
                    paramH.value1D += aShifthold == 1 ? 4096 : 256;
                    break;
                case 11:
                    paramH.value0D *= aShifthold == 1 ? 4096 : 256;
                    paramH.value1D *= aShifthold == 1 ? 4096 : 256;
                    break;
                case 12:
                    paramH.param += aShifthold == 1 ? 2 : 1;
                    break;
                case 13:
                    paramH.value0D += aShifthold == 1 ? 16 : 1;
                    break;
                case 14:
                    paramH.value1D += aShifthold == 1 ? 16 : 1;
                    break;
                case 15:
                    paramH.value0D *= aShifthold == 1 ? 16 : 2;
                    paramH.value1D *= aShifthold == 1 ? 16 : 2;
                    break;
                default:
                    doStuff = false;
            }
            if (doStuff) {
                IGregTechTileEntity base=paramH.getBaseMetaTileEntity();
                TecTech.proxy.playSound(base,"fx_click");
                if (paramH.param > 9) {
                    paramH.param = 9;
                } else if (paramH.param < -1) {
                    paramH.param = -1;
                }
            }
        }
        return super.slotClick(aSlotIndex, aMouseclick, aShifthold, aPlayer);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        if (mTileEntity.isClientSide() || mTileEntity.getMetaTileEntity() == null) {
            return;
        }
        param = ((GT_MetaTileEntity_Hatch_Param) mTileEntity.getMetaTileEntity()).param;
        value0d = ((GT_MetaTileEntity_Hatch_Param) mTileEntity.getMetaTileEntity()).value0D;
        value1d = ((GT_MetaTileEntity_Hatch_Param) mTileEntity.getMetaTileEntity()).value1D;
        input0d = ((GT_MetaTileEntity_Hatch_Param) mTileEntity.getMetaTileEntity()).input0D;
        input1d = ((GT_MetaTileEntity_Hatch_Param) mTileEntity.getMetaTileEntity()).input1D;

        for (Object crafter : crafters) {
            ICrafting var1 = (ICrafting) crafter;
            Util.sendInteger(param,this,var1,100);
            Util.sendDouble(value0d,this,var1,102);
            Util.sendDouble(value1d,this,var1, 106);
            Util.sendDouble(input0d,this,var1, 110);
            Util.sendDouble(input1d,this,var1, 114);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2) {
        super.updateProgressBar(par1, par2);
        switch (par1) {
            case 100:
            case 101:
                param=Util.receiveInteger(param,100,par1,par2);
                return;
            case 102:
            case 103:
            case 104:
            case 105:
                value0d =Double.longBitsToDouble(value0l=Util.receiveLong(value0l,102,par1,par2));
                return;
            case 106:
            case 107:
            case 108:
            case 109:
                value1d =Double.longBitsToDouble(value1l=Util.receiveLong(value1l,106,par1,par2));
                return;
            case 110:
            case 111:
            case 112:
            case 113:
                input0d =Double.longBitsToDouble(input0l=Util.receiveLong(input0l,110,par1,par2));
                return;
            case 114:
            case 115:
            case 116:
            case 117:
                input1d =Double.longBitsToDouble(input1l=Util.receiveLong(input1l,114,par1,par2));
                return;
            default:
        }
    }
}
