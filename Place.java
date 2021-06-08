package com.example.os;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 1, 16},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"},
        d2 = {"Lcom/cookandroid/OS/Place;", "", "place_name", "", "address_name", "road_address_name", "x", "y", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress_name", "()Ljava/lang/String;", "setAddress_name", "(Ljava/lang/String;)V", "getPlace_name", "setPlace_name", "getRoad_address_name", "setRoad_address_name", "getX", "setX", "getY", "setY", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "OS.app"}
)


public final class Place {
    @NotNull
    private String place_name;
    @NotNull
    private String address_name;
    @NotNull
    private String road_address_name;
    @NotNull
    private String x;
    @NotNull
    private String y;

    @NotNull
    public final String getPlace_name() {
        return this.place_name;
    }

    public final void setPlace_name(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.place_name = var1;
    }

    @NotNull
    public final String getAddress_name() {
        return this.address_name;
    }

    public final void setAddress_name(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.address_name = var1;
    }

    @NotNull
    public final String getRoad_address_name() {
        return this.road_address_name;
    }

    public final void setRoad_address_name(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.road_address_name = var1;
    }

    @NotNull
    public final String getX() {
        return this.x;
    }

    public final void setX(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.x = var1;
    }

    @NotNull
    public final String getY() {
        return this.y;
    }

    public final void setY(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.y = var1;
    }

    public Place(@NotNull String place_name, @NotNull String address_name, @NotNull String road_address_name, @NotNull String x, @NotNull String y) {
        Intrinsics.checkParameterIsNotNull(place_name, "place_name");
        Intrinsics.checkParameterIsNotNull(address_name, "address_name");
        Intrinsics.checkParameterIsNotNull(road_address_name, "road_address_name");
        Intrinsics.checkParameterIsNotNull(x, "x");
        Intrinsics.checkParameterIsNotNull(y, "y");
        //super();
        this.place_name = place_name;
        this.address_name = address_name;
        this.road_address_name = road_address_name;
        this.x = x;
        this.y = y;
    }

    @NotNull
    public final String component1() {
        return this.place_name;
    }

    @NotNull
    public final String component2() {
        return this.address_name;
    }

    @NotNull
    public final String component3() {
        return this.road_address_name;
    }

    @NotNull
    public final String component4() {
        return this.x;
    }

    @NotNull
    public final String component5() {
        return this.y;
    }

    @NotNull
    public final Place copy(@NotNull String place_name, @NotNull String address_name, @NotNull String road_address_name, @NotNull String x, @NotNull String y) {
        Intrinsics.checkParameterIsNotNull(place_name, "place_name");
        Intrinsics.checkParameterIsNotNull(address_name, "address_name");
        Intrinsics.checkParameterIsNotNull(road_address_name, "road_address_name");
        Intrinsics.checkParameterIsNotNull(x, "x");
        Intrinsics.checkParameterIsNotNull(y, "y");
        return new Place(place_name, address_name, road_address_name, x, y);
    }

    // $FF: synthetic method
    public static Place copy$default(Place var0, String var1, String var2, String var3, String var4, String var5, int var6, Object var7) {
        if ((var6 & 1) != 0) {
            var1 = var0.place_name;
        }

        if ((var6 & 2) != 0) {
            var2 = var0.address_name;
        }

        if ((var6 & 4) != 0) {
            var3 = var0.road_address_name;
        }

        if ((var6 & 8) != 0) {
            var4 = var0.x;
        }

        if ((var6 & 16) != 0) {
            var5 = var0.y;
        }

        return var0.copy(var1, var2, var3, var4, var5);
    }

    @NotNull
    public String toString() {
        return "Place(place_name=" + this.place_name + ", address_name=" + this.address_name + ", road_address_name=" + this.road_address_name + ", x=" + this.x + ", y=" + this.y + ")";
    }

    public int hashCode() {
        String var10000 = this.place_name;
        int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
        String var10001 = this.address_name;
        var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
        var10001 = this.road_address_name;
        var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
        var10001 = this.x;
        var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
        var10001 = this.y;
        return var1 + (var10001 != null ? var10001.hashCode() : 0);
    }

    public boolean equals(@Nullable Object var1) {
        if (this != var1) {
            if (var1 instanceof Place) {
                Place var2 = (Place)var1;
                if (Intrinsics.areEqual(this.place_name, var2.place_name) && Intrinsics.areEqual(this.address_name, var2.address_name) && Intrinsics.areEqual(this.road_address_name, var2.road_address_name) && Intrinsics.areEqual(this.x, var2.x) && Intrinsics.areEqual(this.y, var2.y)) {
                    return true;
                }
            }

            return false;
        } else {
            return true;
        }
    }
}