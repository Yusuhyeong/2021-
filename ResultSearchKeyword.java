package com.example.os;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 1, 16},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"},
        d2 = {"Lcom/cookandroid/OS/ResultSearchKeyword;", "", "documents", "", "Lcom/cookandroid/OS/Place;", "(Ljava/util/List;)V", "getDocuments", "()Ljava/util/List;", "setDocuments", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OS.app"}
)

public class ResultSearchKeyword {
    @NotNull
    public List<Place> documents;

    @NotNull
    public final List getDocuments() {
        return this.documents;
    }

    public final void setDocuments(@NotNull List var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.documents = var1;
    }

    public ResultSearchKeyword(@NotNull List documents) {
        Intrinsics.checkParameterIsNotNull(documents, "documents");
        //super();
        this.documents = documents;
    }

    @NotNull
    public final List component1() {
        return this.documents;
    }

    @NotNull
    public final ResultSearchKeyword copy(@NotNull List documents) {
        Intrinsics.checkParameterIsNotNull(documents, "documents");
        return new ResultSearchKeyword(documents);
    }

    // $FF: synthetic method
    public static ResultSearchKeyword copy$default(ResultSearchKeyword var0, List var1, int var2, Object var3) {
        if ((var2 & 1) != 0) {
            var1 = var0.documents;
        }

        return var0.copy(var1);
    }

    @NotNull
    public String toString() {
        return "ResultSearchKeyword(documents=" + this.documents + ")";
    }

    public int hashCode() {
        List var10000 = this.documents;
        return var10000 != null ? var10000.hashCode() : 0;
    }

    public boolean equals(@Nullable Object var1) {
        if (this != var1) {
            if (var1 instanceof ResultSearchKeyword) {
                ResultSearchKeyword var2 = (ResultSearchKeyword)var1;
                if (Intrinsics.areEqual(this.documents, var2.documents)) {
                    return true;
                }
            }

            return false;
        } else {
            return true;
        }
    }
}
