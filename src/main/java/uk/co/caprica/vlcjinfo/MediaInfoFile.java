package uk.co.caprica.vlcjinfo;

import com.sun.jna.Pointer;
import com.sun.jna.WString;
import uk.co.caprica.vlcjinfo.binding.LibMediaInfo;

import java.io.File;

/**
 * Media information for a file.
 * <p>
 * This class opens a media file, keeps it open while you perform operations on it, until you explicitly close it.
 */
public final class MediaInfoFile {

    /**
     * Filename.
     */
    private final String filename;

    /**
     * Opaque native library handle.
     */
    private Pointer handle;

    /**
     * Create a media info file wrapper.
     *
     * @param file media file
     */
    public MediaInfoFile(File file) {
        this(file.getAbsolutePath());
    }

    /**
     * Create a media info file wrapper.
     *
     * @param filename name of the media file
     */
    public MediaInfoFile(String filename) {
        this.filename = filename;
    }

    /**
     * Open the media file.
     *
     * @return <code>true</code> if the file was opened successfully; <code>false</code> if it was not
     */
    public boolean open() {
        LibMediaInfo lib = LibMediaInfo.INSTANCE;
        handle = lib.MediaInfo_New();
        if (handle != null) {
            int opened = lib.MediaInfo_Open(handle, new WString(filename));
            if (opened == 1) {
                return true;
            } else {
                lib.MediaInfo_Delete(handle);
            }
        }
        return false;
    }

    /**
     * Get an item of media information from the file.
     * <p>
     * The supplied value may contain a format string, it has the exact same format as supplied to the command-line
     * tool, for example:
     * <pre>
     * Video;%Duration/String3%
     * </pre>
     *
     * @param value input string describing the name of the piece of required information, and optionally how it should be formatted
     * @return information
     */
    public String info(String value) {
        LibMediaInfo.INSTANCE.MediaInfo_Option(null, new WString("Inform"), new WString(value));
        WString result = LibMediaInfo.INSTANCE.MediaInfo_Inform(handle);
        return result != null ? result.toString() : null;
    }

    /**
     * Close the media file.
     */
    public void close() {
        if (handle != null) {
            LibMediaInfo.INSTANCE.MediaInfo_Close(handle);
            LibMediaInfo.INSTANCE.MediaInfo_Delete(handle);
        }
    }

}
