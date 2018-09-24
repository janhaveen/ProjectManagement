package com.general.file;
import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.callbacks.DbxGlobalCallbackFactory;
import com.dropbox.core.v2.callbacks.DbxRouteErrorCallback;
import com.dropbox.core.v2.callbacks.DbxNetworkErrorCallback;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

import java.util.List;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;

public class DownloadFile {
    private static final String ACCESS_TOKEN = "6rdOKk-CwgAAAAAAAAAAWvfY0oWkuR7NeGcjTDI3aTUEvSLPKBTuTVIoWWW8Ybbq";

    public static void main(String args[]) throws DbxException, IOException {
       
    }
    
    public static void downloadFile1(String src) throws DbxApiException, DbxException, FileNotFoundException, IOException {
    	 // Create Dropbox client
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial");
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        // Get current account info
        FullAccount account = client.users().getCurrentAccount();
        System.out.println(account.getName().getDisplayName());

        // Get files and folder metadata from Dropbox root directory
        ListFolderResult result = client.files().listFolder("");
        while (true) {
            for (Metadata metadata : result.getEntries()) {
                System.out.println(metadata.getPathLower());
            }

            if (!result.getHasMore()) {
                break;
            }

            result = client.files().listFolderContinue(result.getCursor());
        }

        // Upload src to Dropbox
        try (InputStream in = new FileInputStream(src)) {
            FileMetadata metadata = client.files().uploadBuilder(src)
                .uploadAndFinish(in);
        }

        DbxDownloader<FileMetadata> downloader = client.files().download(src);
        try {
            FileOutputStream out = new FileOutputStream(src);
            downloader.download(out);
            out.close();
        } catch (DbxException ex) {
            System.out.println(ex.getMessage());
        }
	}
} 