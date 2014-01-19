package albo.huffman;

import helpers.Reader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.BitSet;
import java.util.Calendar;
import java.util.HashMap;

import com.googlecode.jinahya.io.BitInput;
import com.googlecode.jinahya.io.BitInput.ByteInput;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import datastructures.binarytree.Node;
import datastructures.binarytree.NodesList;
import datastructures.binarytree.Root;

public class HuffmanCompression {

	private String inputFilePath;
	private String compressedFilePath;
	private String decodedFilePath;

	private BitSet bits;
	private NodesList boundedNodes = new NodesList();
	private String text = "";
	private HashMap<String, String> encodingMap;
	private Root root;
	private String compressedText = "";
	private NodesList nl = new NodesList();

	public HuffmanCompression(String inputFilePath, String pCompressedFilePath,
			String pDecodedFilePath) {
		this.inputFilePath = inputFilePath;
		this.compressedFilePath = pCompressedFilePath;
		this.decodedFilePath = pDecodedFilePath;
	}

	public void compress() throws IOException {
		Reader reader = new Reader(inputFilePath);
		StringBuilder sb = new StringBuilder();

	
		long startTime = Calendar.getInstance().getTimeInMillis();
		// reading letter by letter
		while (reader.hasNext()) {
			char c = reader.getChar();
			sb.append(c);
			nl.add(c);
		}
		text = sb.toString();

		// setting all unique characters in ArrayList
		nl.setChars();

		// building a tree
		while (nl.getList().size() >= 2) {
			nl.sortAscending();
			Root r = new Root();
			Node child0 = nl.remove(0);
			Node child1 = nl.remove(0);

			child0.setParent(r);
			child1.setParent(r);

			child0.setId("0");
			child1.setId("1");

			r.setChild0(child0);
			r.setChild1(child1);

			if (!(child0 instanceof Root))
				boundedNodes.add(child0);
			if (!(child1 instanceof Root))
				boundedNodes.add(child1);

			r.setFrequency(child1.getFrequency() + child0.getFrequency());
			nl.add(r);
		}

		// setting root for compression
		root = (Root) nl.getList().get(0);
		encodingMap = getEncodingMap();

		// saving tree in file
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				new File(inputFilePath.substring(0, inputFilePath.length() - 4)
						+ ".tree")));
		try {
			oos.writeObject(root);
		} finally {
			oos.close();
		}

		// encoding text with binary code
		BitSet bs = encode();
		// saving compressed file
		File f = new File(inputFilePath.substring(0, inputFilePath.length() - 4) + ".huf");
		ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream(f));
		dos.writeObject(bs);
		dos.close();
		System.out
				.println("Compression completed.\nIt took "
						+ (Calendar.getInstance().getTimeInMillis() - startTime * 1.0 / 1000)
						+ " seconds.\n" + "File size before compression = "
						+ reader.getFileSize() + "\nAfter compression = "
						+ f.length() + ".\n" + "Compression ratio: "
						+ ((1.0 * f.length()) / reader.getFileSize()) + "\n\n");
	}

	public void decompress() throws IOException, ClassNotFoundException {
		long startTime = Calendar.getInstance().getTimeInMillis();
		StringBuilder sb = new StringBuilder();
		File f = new File(decodedFilePath);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));

		/***********************************************************/
		// Reading tree from file
		File fTree = new File(inputFilePath.substring(0,inputFilePath.length() - 4) + ".tree");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fTree));
		Root treeFromFile = null;
		try {
			treeFromFile = (Root) ois.readObject();
		} finally {
			ois.close();
		}

		root = treeFromFile;

		/***********************************************************/
		// Reading encoded file
		File fCompressed = new File(inputFilePath.substring(0, inputFilePath.length() - 4)	+ ".huf");
		long fileSizeBefore = fCompressed.length();
		ois = new ObjectInputStream(new FileInputStream(fCompressed));
		BitSet bs = null;
		try {
			bs = (BitSet) ois.readObject();
		} finally {
			ois.close();
		}
		// text from file --> String
		int i = 0;
		do {
			boolean bit = bs.get(i);
			if (bit) {
				sb.append("1");
			} else {
				sb.append("0");
			}
			i++;
		} while (i <= bs.length());
		compressedText = sb.toString();
		/***********************************************************/

		// decompression
		sb = new StringBuilder();
		Node n = (Node) root;
		i = 0;
		String code = "";
		// while for traversing whole file
		while (i < compressedText.length()) {
			// while for getting single word
			code = "";
			while (n.getVal() == null && i < compressedText.length()) {
				String bit = String.valueOf(compressedText.charAt(i));
				if (bit.equals("0")) {
					code += "0";
					n = n.getChild0();
				} else if (bit.equals("1")) {
					n = n.getChild1();
					code += "1";
				}
				i++;
			}
			if(n.getVal() != null){
				sb.append(n.getVal());
				code = "";
			}
			n = (Node) root;
		}
		System.out.println(code);
		
		try {
			bos.write(sb.toString().getBytes());
		} finally {
			bos.close();
		}

		System.out
				.println("Decompression completed.\nIt took "
						+ (Calendar.getInstance().getTimeInMillis() - startTime * 1.0 / 1000)
						+ " seconds.\n" + "File size before decompression = "
						+ fileSizeBefore + "\nAfter decompression = "
						+ f.length() + ".\n");
	}

	public void printEncodingMap() {
		for (String s : encodingMap.keySet()) {
			System.out.println(s + "  :   " + encodingMap.get(s));
		}
	}

	private HashMap<String, String> getEncodingMap() {
		HashMap<String, String> encodingTable = new HashMap<String, String>();

		for (Character c : nl.getChars()) {
			StringBuilder codeBuilder = new StringBuilder();
			Node n = findNode(c, boundedNodes);
			do {
				codeBuilder.append(n.getId());
				n = n.getParent();
			} while (n.getParent() != null);
			encodingTable.put(String.valueOf(c), codeBuilder.reverse()
					.toString());
		}

		return encodingTable;
	}

	private BitSet encode() throws IOException {

		StringBuilder encodedSB = new StringBuilder();
		for (char c : text.toCharArray()) {
			encodedSB.append(encodingMap.get(String.valueOf(c)));
		}
		char[] encodedString = encodedSB.toString().toCharArray();
		compressedText = encodedSB.toString();

		BitSet bs = new BitSet(encodedString.length);
		for (int i = 0; i < encodedString.length; i++) {
			if (encodedString[i] == '1') {
				bs.set(i);
			}
		}

		return bs;
	}

	private Node findNode(Character c, NodesList pNodesList) {
		for (Node n : pNodesList.getList()) {
			if (c.equals(n.getVal())) {
				return n;
			}
		}
		return null;
	}

}
