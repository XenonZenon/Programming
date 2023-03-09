
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Process
{
  private static String home = "/home/xenonzenon/Noysoft/SoftwareEngineering/Programming/Java/imageprocessing";

  public static void main(String args[])
  {
    int width = 800;
    int height = 600;

    // String imagename = "baybayin";
    // Sepia(imagename, imagename + "-sepia", width, height);
    // RedImage(imagename, imagename + "-red", width, height);
    // GreenImage(imagename, imagename + "-green", width, height);
    // BlueImage(imagename, imagename + "-blue", width, height);
    // Negative(imagename, imagename + "-negative", width, height);

    RandomImage("random-image", width, height);
  }

  public static BufferedImage ReadImage(BufferedImage image, int width, int height, String name)
  {
    // Read
    try {
      File input_file = new File(home + "/Image/input/" + name + ".png");
      // image file path create an object of
      // BufferedImage type and pass as parameter the
      // width, height and image int
      // type. TYPE_INT_ARGB means that we are
      // representing the Alpha , Red, Green and Blue
      // component of the image pixel using 8 bit
      // integer value.

      image = new BufferedImage(
        width, height, BufferedImage.TYPE_INT_ARGB);

      // Reading input file
      image = ImageIO.read(input_file);

      System.out.println("Reading complete.");
    }
    catch (IOException e) {
      System.out.println("Error: " + e);
    }

    return image;
  }

  public static void WriteImage(BufferedImage image, String name)
  {
    // Write
    try {
			// Output file path
			File output_file = new File(home + "/Image/output/" + name + ".png");

			// Writing to file taking type and path as
			ImageIO.write(image, "png", output_file);

			System.out.println("Writing "+ name +" complete.");
		}
		catch (IOException e) {
			System.out.println("Error: " + e);
		}
  }

  //  Sepia
  public static void Sepia(String input, String output, int width, int height)
  {
    BufferedImage image = null;
    image = ReadImage(image, width, height, input);

    for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				int p = image.getRGB(x, y);

				int a = (p >> 24) & 0xff;
				int R = (p >> 16) & 0xff;
				int G = (p >> 8) & 0xff;
				int B = p & 0xff;

				// calculate newRed, newGreen, newBlue
				int newRed = (int)(0.393 * R + 0.769 * G
								+ 0.189 * B);
				int newGreen = (int)(0.349 * R + 0.686 * G
									+ 0.168 * B);
				int newBlue = (int)(0.272 * R + 0.534 * G
									+ 0.131 * B);

				// check condition
				if (newRed > 255)
					R = 255;
				else
					R = newRed;

				if (newGreen > 255)
					G = 255;
				else
					G = newGreen;

				if (newBlue > 255)
					B = 255;
				else
					B = newBlue;

				// set new RGB value
				p = (a << 24) | (R << 16) | (G << 8) | B;

				image.setRGB(x, y, p);
			}
		}

    WriteImage(image, output);
    image = null;
  }

  // GrayScale
  public static void GrayScale(String input, String output, int width, int height)
  {
    BufferedImage image = null;
    image = ReadImage(image, width, height, input);
    // convert to grayscale
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {

				// Here (x,y)denotes the coordinate of image
				// for modifying the pixel value.
				int p = image.getRGB(x, y);

				int a = (p >> 24) & 0xff;
				int r = (p >> 16) & 0xff;
				int g = (p >> 8) & 0xff;
				int b = p & 0xff;

				// calculate average
				int avg = (r + g + b) / 3;

				// replace RGB value with avg
				p = (a << 24) | (avg << 16) | (avg << 8)
					| avg;

				image.setRGB(x, y, p);
			}
		}

    WriteImage(image, output);
    image = null;
  }

  public static void RedImage(String input, String output, int width, int height)
  {
    BufferedImage image = null;
    image = ReadImage(image, width, height, input);
    // convert to red image
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				int p = image.getRGB(x, y);

				int a = (p >> 24) & 0xff;
				int r = (p >> 16) & 0xff;

				// set new RGB keeping the r
				// value same as in original image
				// and setting g and b as 0.
				p = (a << 24) | (r << 16) | (0 << 8) | 0;

				image.setRGB(x, y, p);
			}
		}

    WriteImage(image, output);
    image = null;
  }

  public static void GreenImage(String input, String output, int width, int height)
  {
    BufferedImage image = null;
    image = ReadImage(image, width, height, input);
    // convert to green image
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				int p = image.getRGB(x, y);

				int a = (p >> 24) & 0xff;
				int g = (p >> 8) & 0xff;

				// set new RGB
				// keeping the g value same as in original
				// image and setting r and b as 0.
				p = (a << 24) | (0 << 16) | (g << 8) | 0;

				image.setRGB(x, y, p);
			}
		}

    WriteImage(image, output);
    image = null;
  }

  public static void BlueImage(String input, String output, int width, int height)
  {
    BufferedImage image = null;
    image = ReadImage(image, width, height, input);
		// convert to blue image
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				int p = image.getRGB(x, y);

				int a = (p >> 24) & 0xff;
				int b = p & 0xff;

				// set new RGB
				// keeping the b value same as in original
				// image and setting r and g as 0.
				p = (a << 24) | (0 << 16) | (0 << 8) | b;

				image.setRGB(x, y, p);
			}
		}

    WriteImage(image, output);
    image = null;
  }

  public static void Negative(String input, String output, int width, int height)
  {
    BufferedImage image = null;
    image = ReadImage(image, width, height, input);
		// Convert to negative
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				int p = image.getRGB(x, y);
				int a = (p >> 24) & 0xff;
				int r = (p >> 16) & 0xff;
				int g = (p >> 8) & 0xff;
				int b = p & 0xff;

				// subtract RGB from 255
				r = 255 - r;
				g = 255 - g;
				b = 255 - b;

				// set new RGB value
				p = (a << 24) | (r << 16) | (g << 8) | b;
				image.setRGB(x, y, p);
			}
		}

    WriteImage(image, output);
    image = null;
  }

  public static void RandomImage(String output, int width, int height)
  {
    BufferedImage image = null;
    image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    // create random values pixel by pixel
    for (int y = 0; y < image.getHeight(); y++)
    {
        for (int x = 0; x < image.getWidth(); x++)
        {
              // generating values less than 256
            int a = (int)(Math.random()*256);
            int r = (int)(Math.random()*256);
            int g = (int)(Math.random()*256);
            int b = (int)(Math.random()*256);

              //pixel
            int p = (a<<24) | (r<<16) | (g<<8) | b;

            image.setRGB(x, y, p);
        }
    }
    WriteImage(image, output);
    image = null;
  }


}
