package tests;

import java.io.IOException;

import org.junit.Test;

import albo.huffman.HuffmanCompression;

public class HuffmanTest {

	
	@Test
	public void test() throws IOException, ClassNotFoundException{
		
		HuffmanCompression hc = new HuffmanCompression("huffmanText.txt", "huffmanEncoded","huffmanDecoded.txt");
		hc.compress();
		hc.decompress();
	}
}
