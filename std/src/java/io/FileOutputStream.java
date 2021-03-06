package java.io;

public class FileOutputStream implements Closeable {
	private FileDescriptor fd;

	public FileOutputStream(String path) {
		this(new File(path));
	}

	public FileOutputStream(File file) {
		this(FileDescriptor.open(file, FileDescriptor.MODE_W));
	}

	public FileOutputStream(FileDescriptor fd) {
		this.fd = fd;
	}

	public void close() throws IOException {
		fd.close();
	}

	public FileDescriptor getFD() {
		return fd;
	}

	protected void finalize() {
		try {
			close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(int b) {
		fd.write(new byte[] {(byte) b});
	}

	public void write(byte[] b) {
		fd.write(b);
	}
}
