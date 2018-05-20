// <editor-fold defaultstate="collapsed" desc="Imports">
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
// </editor-fold>

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author v-royhar
 */
public class MainFrame extends javax.swing.JFrame {

    // Strings to build the URI for the REST API calls.
    public static final String uriBasePreRegion = "https://";
    public static final String uriBasePostRegion = ".api.cognitive.microsoft.com/vision/";
    public static final String uriBaseAnalyze = "v1.0/analyze";
    public static final String uriBaseOcr = "v1.0/ocr";
    public static final String uriBaseHandwriting = "v1.0/recognizeText";
    public static final String key = "";
    public static final String zone = "northeurope";

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        analyzePanel = new javax.swing.JPanel();
        analyzeTitleLabel = new javax.swing.JLabel();
        analyzeInstructionLabel = new javax.swing.JLabel();
        analyzeImagePromptLabel = new javax.swing.JLabel();
        analyzeImageUriTextBox = new javax.swing.JTextField();
        analyzeImageButton = new javax.swing.JButton();
        analyzeResponseLabel = new javax.swing.JLabel();
        analyzeSourceImageLabel = new javax.swing.JLabel();
        analyzeScrollPane = new javax.swing.JScrollPane();
        analyzeResponseTextArea = new javax.swing.JTextArea();
        analyzeImage = new javax.swing.JLabel();
        analyzeCaptionLabel = new javax.swing.JLabel();
        ocrPanel = new javax.swing.JPanel();
        ocrTitleLabel = new javax.swing.JLabel();
        ocrInstructionLabel = new javax.swing.JLabel();
        ocrImagePromptLabel = new javax.swing.JLabel();
        ocrImageUriTextBox = new javax.swing.JTextField();
        ocrImageButton = new javax.swing.JButton();
        ocrResponseLabel = new javax.swing.JLabel();
        ocrSourceImageLabel = new javax.swing.JLabel();
        ocrScrollPane = new javax.swing.JScrollPane();
        ocrResponseTextArea = new javax.swing.JTextArea();
        ocrImage = new javax.swing.JLabel();
        handwritingPanel = new javax.swing.JPanel();
        handwritingTitleLabel = new javax.swing.JLabel();
        handwritingInstructionLabel = new javax.swing.JLabel();
        handwritingImagePromptLabel = new javax.swing.JLabel();
        handwritingImageUriTextBox = new javax.swing.JTextField();
        handwritingImageButton = new javax.swing.JButton();
        handwritingResponseLabel = new javax.swing.JLabel();
        handwritingSourceImageLabel = new javax.swing.JLabel();
        handwritingScrollPane = new javax.swing.JScrollPane();
        handwritingResponseTextArea = new javax.swing.JTextArea();
        handwritingImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(960, 600));

        analyzeTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        analyzeTitleLabel.setText("Analyze image:");

        analyzeInstructionLabel.setText("Enter the URL to an image you want to analyze, then click the \"Analyze Image\" button. ");

        analyzeImagePromptLabel.setText("Image to analyze:");

        analyzeImageUriTextBox.setText("");

        analyzeImageButton.setText("Analyze Image");
        analyzeImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyzeImageButtonActionPerformed(evt);
            }
        });

        analyzeResponseLabel.setText("Response:");

        analyzeSourceImageLabel.setText("Source image:");

        analyzeResponseTextArea.setEditable(false);
        analyzeResponseTextArea.setColumns(20);
        analyzeResponseTextArea.setRows(5);
        analyzeScrollPane.setViewportView(analyzeResponseTextArea);

        javax.swing.GroupLayout analyzePanelLayout = new javax.swing.GroupLayout(analyzePanel);
        analyzePanel.setLayout(analyzePanelLayout);
        analyzePanelLayout.setHorizontalGroup(
            analyzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(analyzePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(analyzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(analyzePanelLayout.createSequentialGroup()
                        .addGroup(analyzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(analyzeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(analyzeResponseLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(analyzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(analyzePanelLayout.createSequentialGroup()
                                .addComponent(analyzeSourceImageLabel)
                                .addGap(0, 437, Short.MAX_VALUE))
                            .addComponent(analyzeImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(analyzeCaptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(analyzePanelLayout.createSequentialGroup()
                        .addGroup(analyzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(analyzePanelLayout.createSequentialGroup()
                                .addComponent(analyzeImagePromptLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(analyzeImageUriTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(analyzeImageButton))
                            .addComponent(analyzeTitleLabel)
                            .addComponent(analyzeInstructionLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        analyzePanelLayout.setVerticalGroup(
            analyzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(analyzePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(analyzeTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(analyzeInstructionLabel)
                .addGap(15, 15, 15)
                .addGroup(analyzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(analyzeImagePromptLabel)
                    .addComponent(analyzeImageUriTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(analyzeImageButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(analyzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(analyzeResponseLabel)
                    .addComponent(analyzeSourceImageLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(analyzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(analyzeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addGroup(analyzePanelLayout.createSequentialGroup()
                        .addComponent(analyzeImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(analyzeCaptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tabbedPane.addTab("Analyze", analyzePanel);

        ocrTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ocrTitleLabel.setText("Optical Character Recognition (OCR):");

        ocrInstructionLabel.setText("Enter the URL to an image of printed text, then click the \"Read Image\" button.");

        ocrImagePromptLabel.setText("Image to read:");

        ocrImageUriTextBox.setText("");

        ocrImageButton.setText("Read Image");
        ocrImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ocrImageButtonActionPerformed(evt);
            }
        });

        ocrResponseLabel.setText("Response:");

        ocrSourceImageLabel.setText("Source image:");

        ocrResponseTextArea.setEditable(false);
        ocrResponseTextArea.setColumns(20);
        ocrResponseTextArea.setRows(5);
        ocrScrollPane.setViewportView(ocrResponseTextArea);

        javax.swing.GroupLayout ocrPanelLayout = new javax.swing.GroupLayout(ocrPanel);
        ocrPanel.setLayout(ocrPanelLayout);
        ocrPanelLayout.setHorizontalGroup(
            ocrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ocrPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ocrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ocrPanelLayout.createSequentialGroup()
                        .addGroup(ocrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ocrTitleLabel)
                            .addComponent(ocrInstructionLabel)
                            .addGroup(ocrPanelLayout.createSequentialGroup()
                                .addComponent(ocrImagePromptLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ocrImageUriTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ocrImageButton)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ocrPanelLayout.createSequentialGroup()
                        .addGroup(ocrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ocrScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ocrResponseLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ocrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ocrPanelLayout.createSequentialGroup()
                                .addComponent(ocrSourceImageLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 447, Short.MAX_VALUE))
                            .addComponent(ocrImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        ocrPanelLayout.setVerticalGroup(
            ocrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ocrPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ocrTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ocrInstructionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ocrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ocrImagePromptLabel)
                    .addComponent(ocrImageUriTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ocrImageButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ocrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ocrResponseLabel)
                    .addComponent(ocrSourceImageLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ocrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ocrImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ocrScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPane.addTab("OCR", ocrPanel);

        handwritingTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        handwritingTitleLabel.setText("Read handwritten text:");

        handwritingInstructionLabel.setText("Enter the URL to an image of handwritten text, then click the \"Read Image\" button.");

        handwritingImagePromptLabel.setText("Image to read:");

        handwritingImageUriTextBox.setText("");

        handwritingImageButton.setText("Read Image");
        handwritingImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handwritingImageButtonActionPerformed(evt);
            }
        });

        handwritingResponseLabel.setText("Response:");

        handwritingSourceImageLabel.setText("Source image:");

        handwritingResponseTextArea.setEditable(false);
        handwritingResponseTextArea.setColumns(20);
        handwritingResponseTextArea.setRows(5);
        handwritingScrollPane.setViewportView(handwritingResponseTextArea);

        javax.swing.GroupLayout handwritingPanelLayout = new javax.swing.GroupLayout(handwritingPanel);
        handwritingPanel.setLayout(handwritingPanelLayout);
        handwritingPanelLayout.setHorizontalGroup(
            handwritingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(handwritingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(handwritingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(handwritingPanelLayout.createSequentialGroup()
                        .addGroup(handwritingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(handwritingTitleLabel)
                            .addComponent(handwritingInstructionLabel)
                            .addGroup(handwritingPanelLayout.createSequentialGroup()
                                .addComponent(handwritingImagePromptLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(handwritingImageUriTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(handwritingImageButton)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(handwritingPanelLayout.createSequentialGroup()
                        .addGroup(handwritingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(handwritingScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(handwritingResponseLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(handwritingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(handwritingPanelLayout.createSequentialGroup()
                                .addComponent(handwritingSourceImageLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 447, Short.MAX_VALUE))
                            .addComponent(handwritingImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        handwritingPanelLayout.setVerticalGroup(
            handwritingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(handwritingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(handwritingTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(handwritingInstructionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(handwritingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(handwritingImagePromptLabel)
                    .addComponent(handwritingImageUriTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(handwritingImageButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(handwritingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(handwritingResponseLabel)
                    .addComponent(handwritingSourceImageLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(handwritingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(handwritingImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(handwritingScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPane.addTab("Read Handwritten Text", handwritingPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabbedPane)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void analyzeImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyzeImageButtonActionPerformed
        URL analyzeImageUrl;
       
        // Clear out the previous image, response, and caption, if any.
        analyzeImage.setIcon(new ImageIcon());
        analyzeCaptionLabel.setText("");
        analyzeResponseTextArea.setText("");
        
        // Display the image specified in the text box.
        try {
            analyzeImageUrl = new URL(analyzeImageUriTextBox.getText());
            BufferedImage bImage = ImageIO.read(analyzeImageUrl);
            scaleAndShowImage(bImage, analyzeImage);
        } catch(IOException e) {
            analyzeResponseTextArea.setText("Error loading Analyze image: " + e.getMessage());
            return;
        }
        
        // Analyze the image.
        JSONObject jsonObj = AnalyzeImage(analyzeImageUrl.toString());
        
        // A return of null indicates failure.
        if (jsonObj == null) {
            return;
        }
        
        // Format and display the JSON response.
        analyzeResponseTextArea.setText(jsonObj.toString(2));
                
        // Extract the text and confidence from the first caption in the description object.
        if (jsonObj.has("description") && jsonObj.getJSONObject("description").has("captions")) {

            JSONObject jsonCaption = jsonObj.getJSONObject("description").getJSONArray("captions").getJSONObject(0);
            
            if (jsonCaption.has("text") && jsonCaption.has("confidence")) {
                
                analyzeCaptionLabel.setText("Caption: " + jsonCaption.getString("text") + 
                        " (confidence: " + jsonCaption.getDouble("confidence") + ").");
            }
        }
    }//GEN-LAST:event_analyzeImageButtonActionPerformed

    /**
     * Encapsulates the Microsoft Cognitive Services REST API call to analyze an image.
     * @param imageUrl: The string URL of the image to analyze.
     * @return: A JSONObject describing the image, or null if a runtime error occurs.
     */
    private JSONObject AnalyzeImage(String imageUrl) {
        try (CloseableHttpClient httpclient = HttpClientBuilder.create().build())
        {
            // Create the URI to access the REST API call for Analyze Image.
            String uriString = uriBasePreRegion + 
                    zone + 
                    uriBasePostRegion + uriBaseAnalyze;
            URIBuilder builder = new URIBuilder(uriString);

            // Request parameters. All of them are optional.
            builder.setParameter("visualFeatures", "Categories,Description,Color,Adult");
            builder.setParameter("language", "en");

            // Prepare the URI for the REST API call.
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);

            // Request headers.
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", key);

            // Request body.
            StringEntity reqEntity = new StringEntity("{\"url\":\"" + imageUrl + "\"}");
            request.setEntity(reqEntity);

            // Execute the REST API call and get the response entity.
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            // If we got a response, parse it and display it.
            if (entity != null)
            {
                // Return the JSONObject.
                String jsonString = EntityUtils.toString(entity);
                return new JSONObject(jsonString);
            } else {
                // No response. Return null.
                return null;
            }
        }
        catch (Exception e)
        {
            // An error occurred. Print error message and return null.
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void ocrImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocrImageButtonActionPerformed
        URL ocrImageUrl;
        
        // Clear out the previous image, response, and caption, if any.
        ocrImage.setIcon(new ImageIcon());
        ocrResponseTextArea.setText("");
        
        // Display the image specified in the text box.
        try {
            ocrImageUrl = new URL(ocrImageUriTextBox.getText());
            BufferedImage bImage = ImageIO.read(ocrImageUrl);
            scaleAndShowImage(bImage, ocrImage);
        } catch(IOException e) {
            ocrResponseTextArea.setText("Error loading OCR image: " + e.getMessage());
            return;
        }
        
        // Read the text in the image.
        JSONObject jsonObj = OcrImage(ocrImageUrl.toString());
        
        // A return of null indicates failure.
        if (jsonObj == null) {
            return;
        }
        
        // Format and display the JSON response.
        ocrResponseTextArea.setText(jsonObj.toString(2));
    }//GEN-LAST:event_ocrImageButtonActionPerformed

     /**
     * Encapsulates the Microsoft Cognitive Services REST API call to read text in an image.
     * @param imageUrl: The string URL of the image to process.
     * @return: A JSONObject describing the image, or null if a runtime error occurs.
     */
    private JSONObject OcrImage(String imageUrl) {
        try (CloseableHttpClient httpclient = HttpClientBuilder.create().build())
        {
            // Create the URI to access the REST API call to read text in an image.
            String uriString = uriBasePreRegion + 
                    zone + 
                    uriBasePostRegion + uriBaseOcr;
            URIBuilder uriBuilder = new URIBuilder(uriString);

            // Request parameters.
            uriBuilder.setParameter("language", "unk");
            uriBuilder.setParameter("detectOrientation ", "true");

            // Prepare the URI for the REST API call.
            URI uri = uriBuilder.build();
            HttpPost request = new HttpPost(uri);

            // Request headers.
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", key);

            // Request body.
            StringEntity reqEntity = new StringEntity("{\"url\":\"" + imageUrl + "\"}");
            request.setEntity(reqEntity);

            // Execute the REST API call and get the response entity.
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            // If we got a response, parse it and display it.
            if (entity != null)
            {
                // Return the JSONObject.
                String jsonString = EntityUtils.toString(entity);
                return new JSONObject(jsonString);
            } else {
                // No response. Return null.
                return null;
            }
        }
        catch (Exception e)
        {
            // Display error message.
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void handwritingImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handwritingImageButtonActionPerformed
        URL handwritingImageUrl;
        
        // Clear out the previous image, response, and caption, if any.
        handwritingImage.setIcon(new ImageIcon());
        handwritingResponseTextArea.setText("");
        
        // Display the image specified in the text box.
        try {
            handwritingImageUrl = new URL(handwritingImageUriTextBox.getText());
            BufferedImage bImage = ImageIO.read(handwritingImageUrl);
            scaleAndShowImage(bImage, handwritingImage);
        } catch(IOException e) {
            handwritingResponseTextArea.setText("Error loading Handwriting image: " + e.getMessage());
            return;
        }
        
        // Read the text in the image.
        JSONObject jsonObj = HandwritingImage(handwritingImageUrl.toString());
        
        // A return of null indicates failure.
        if (jsonObj == null) {
            return;
        }
        
        // Format and display the JSON response.
        handwritingResponseTextArea.setText(jsonObj.toString(2));
    }//GEN-LAST:event_handwritingImageButtonActionPerformed

     /**
     * Encapsulates the Microsoft Cognitive Services REST API call to read handwritten text in an image.
     * @param imageUrl: The string URL of the image to process.
     * @return: A JSONObject describing the image, or null if a runtime error occurs.
     */
    private JSONObject HandwritingImage(String imageUrl) {
        try (CloseableHttpClient textClient = HttpClientBuilder.create().build();
             CloseableHttpClient resultClient = HttpClientBuilder.create().build())
        {
            // Create the URI to access the REST API call to read text in an image.
            String uriString = uriBasePreRegion + 
                    zone + 
                    uriBasePostRegion + uriBaseHandwriting;
            URIBuilder uriBuilder = new URIBuilder(uriString);
            
            // Request parameters.
            uriBuilder.setParameter("handwriting", "true");

            // Prepare the URI for the REST API call.
            URI uri = uriBuilder.build();
            HttpPost request = new HttpPost(uri);

            // Request headers.
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", key);

            // Request body.
            StringEntity reqEntity = new StringEntity("{\"url\":\"" + imageUrl + "\"}");
            request.setEntity(reqEntity);

            // Execute the REST API call and get the response.
            HttpResponse textResponse = textClient.execute(request);
            
            // Check for success.
            if (textResponse.getStatusLine().getStatusCode() != 202) {
                // An error occured. Return the JSON error message.
                HttpEntity entity = textResponse.getEntity();
                String jsonString = EntityUtils.toString(entity);
                return new JSONObject(jsonString);
            }
            
            String operationLocation = null;

            // The 'Operation-Location' in the response contains the URI to retrieve the recognized text.
            Header[] responseHeaders = textResponse.getAllHeaders();
            for(Header header : responseHeaders) {
                if(header.getName().equals("Operation-Location"))
                {
                    // This string is the URI where you can get the text recognition operation result.
                    operationLocation = header.getValue();
                    break;
                }
            }
            
            // NOTE: The response may not be immediately available. Handwriting recognition is an
            // async operation that can take a variable amount of time depending on the length
            // of the text you want to recognize. You may need to wait or retry this operation.
            //
            // This example checks once per second for ten seconds.
            
            JSONObject responseObj = null;
            int i = 0;
            do {
                // Wait one second.
                Thread.sleep(1000);
                
                // Check to see if the operation completed.
                HttpGet resultRequest = new HttpGet(operationLocation);
                resultRequest.setHeader("Ocp-Apim-Subscription-Key", key);
                HttpResponse resultResponse = resultClient.execute(resultRequest);
                HttpEntity responseEntity = resultResponse.getEntity();
                if (responseEntity != null)
                {
                    // Get the JSON response.
                    String jsonString = EntityUtils.toString(responseEntity);
                    responseObj = new JSONObject(jsonString);
                }
            }
            while (i < 10 && responseObj != null &&
                    !responseObj.getString("status").equalsIgnoreCase("Succeeded"));
            
            // If the operation completed, return the JSON object.
            if (responseObj != null) {
                return responseObj;
            } else {
                // Return null for timeout error.
                System.out.println("Timeout error.");
                return null;
            }
        }
        catch (Exception e)
        {
            // Display error message.
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Scales the given image to fit the label dimensions.
     * @param bImage: The image to fit.
     * @param label: The label to display the image.
     */
    private void scaleAndShowImage(BufferedImage bImage, JLabel label) {
        int bImageHeight = bImage.getHeight();
        int bImageWidth = bImage.getWidth();
        int labelHeight = label.getHeight();
        int labelWidth = label.getWidth();
        
        // Does this need to be scaled?
        if (labelHeight >= bImageHeight && labelWidth >= bImageWidth) {
            // If not, display the image and return.
            ImageIcon image = new ImageIcon(bImage);
            label.setIcon(image);
            return;
        }
        
        // Calculate the new width and height for the image.
        int newHeight;
        int newWidth;
        double bImageAspect = (double)bImageHeight / (double)bImageWidth;
        double labelAspect = (double)labelHeight / (double)labelWidth;
        
        if (bImageAspect > labelAspect) {
            newHeight = labelHeight;
            newWidth = (int)(((double)labelHeight / (double)bImageHeight) * (double)bImageWidth);
        } else {
            newWidth = labelWidth;
            newHeight = (int)(((double)labelWidth / (double)bImageWidth) * (double)bImageHeight);
        }
        
        // Create a new image scaled to the correct size.
        Image newImage = bImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        
        // Display the scaled image.
        ImageIcon labelImage = new ImageIcon(newImage);
        label.setIcon(labelImage);
        label.validate();
        label.repaint();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel analyzeCaptionLabel;
    private javax.swing.JLabel analyzeImage;
    private javax.swing.JButton analyzeImageButton;
    private javax.swing.JLabel analyzeImagePromptLabel;
    private javax.swing.JTextField analyzeImageUriTextBox;
    private javax.swing.JLabel analyzeInstructionLabel;
    private javax.swing.JPanel analyzePanel;
    private javax.swing.JLabel analyzeResponseLabel;
    private javax.swing.JTextArea analyzeResponseTextArea;
    private javax.swing.JScrollPane analyzeScrollPane;
    private javax.swing.JLabel analyzeSourceImageLabel;
    private javax.swing.JLabel analyzeTitleLabel;
    private javax.swing.JLabel handwritingImage;
    private javax.swing.JButton handwritingImageButton;
    private javax.swing.JLabel handwritingImagePromptLabel;
    private javax.swing.JTextField handwritingImageUriTextBox;
    private javax.swing.JLabel handwritingInstructionLabel;
    private javax.swing.JPanel handwritingPanel;
    private javax.swing.JLabel handwritingResponseLabel;
    private javax.swing.JTextArea handwritingResponseTextArea;
    private javax.swing.JScrollPane handwritingScrollPane;
    private javax.swing.JLabel handwritingSourceImageLabel;
    private javax.swing.JLabel handwritingTitleLabel;
    private javax.swing.JLabel landmarkCaptionLabel;
    private javax.swing.JLabel landmarkImage;
    private javax.swing.JButton landmarkImageButton;
    private javax.swing.JLabel landmarkImagePromptLabel;
    private javax.swing.JTextField landmarkImageUriTextBox;
    private javax.swing.JLabel landmarkInstructionLabel;
    private javax.swing.JPanel landmarkPanel;
    private javax.swing.JLabel landmarkResponseLabel;
    private javax.swing.JTextArea landmarkResponseTextArea;
    private javax.swing.JScrollPane landmarkScrollPane;
    private javax.swing.JLabel landmarkSourceImageLabel;
    private javax.swing.JLabel landmarkTitleLabel;
    private javax.swing.JLabel ocrImage;
    private javax.swing.JButton ocrImageButton;
    private javax.swing.JLabel ocrImagePromptLabel;
    private javax.swing.JTextField ocrImageUriTextBox;
    private javax.swing.JLabel ocrInstructionLabel;
    private javax.swing.JPanel ocrPanel;
    private javax.swing.JLabel ocrResponseLabel;
    private javax.swing.JTextArea ocrResponseTextArea;
    private javax.swing.JScrollPane ocrScrollPane;
    private javax.swing.JLabel ocrSourceImageLabel;
    private javax.swing.JLabel ocrTitleLabel;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
