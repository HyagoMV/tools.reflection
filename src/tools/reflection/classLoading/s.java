/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.commons.vfs2.FileContent
 *  org.apache.commons.vfs2.FileObject
 *  org.apache.commons.vfs2.FileSystemException
 *  org.apache.commons.vfs2.FileSystemManager
 *  org.apache.commons.vfs2.FileUtil
 *  org.apache.commons.vfs2.VFS
 */
package tools.reflection.classLoading;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.vfs2.FileContent;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.FileUtil;
import org.apache.commons.vfs2.VFS;
import org.jetbrains.annotations.NotNull;

public final class s {
    @NotNull
    private FileSystemManager a;
    
    {
    	try {
			a = VFS.getManager();
		} catch (FileSystemException e) {
			e.printStackTrace();
		}
    }

    @NotNull
    public FileObject a(@NotNull String string) throws FileSystemException {
        String string2 = !string.startsWith("ram://") ? "ram://" + string : string;
        return this.a.resolveFile(string2);
    }

    public boolean a(@NotNull FileObject fileObject, @NotNull byte[] byArray) {
        try {
            fileObject.createFile();
            FileContent fileContent = fileObject.getContent();
            OutputStream outputStream = fileContent.getOutputStream();
            outputStream.write(byArray);
            outputStream.close();
        }
        catch (IOException iOException) {
            return false;
        }
        return true;
    }

    @NotNull
    public byte[] a(@NotNull FileObject fileObject) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileUtil.writeContent((FileObject)fileObject, (OutputStream)byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}

