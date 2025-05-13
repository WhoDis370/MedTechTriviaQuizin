
import java.util.ArrayList;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class QuestionGenerator {
       public static Question[][] generateQuestions() {
        int rows = 5;
        int cols = 5;
        Question[][] questions = new Question[rows][cols];

        String[] sampleQuestions = {
            "The following supplies were gathered for a routine venipuncture. Which item is incorrect?",
            "Which of the following tubes can be used to collect a serum specimen?",
            "A tourniquet is used in venipucture to:",
            "Which of the following needles has the largest diameter?",
            "What causes evacuated tubes to fill with blood automatically?",
            "Which of the following is a preanalytical component of the laboratory quality assessment control?",
            "Which of the following is a postanalytical component of the laboratory quality assessment control?",
            "Analytical components of a laboratory quality assessment program are procedures and policies that affect the",
            "Why are written procedures necessary?",
            "Which of the following is not considered to be an analytical component of a laboratory quality assessment?",
            "Which of the following staining procedures relies on the cationic and anionic properties of the material to be stained?",
            "In a light microscope used for histology, resolution and magnification of cells are largely dependent on which component?",
            "Resolution in electron microscopy greatly exceeds that of light microscopy due to which of the following?",
            "Microscopic autoradiography uses radioactivity and can be employed to study what features in a tissue section?",
            "To identify and localize a specific protein within cells or the extracellular matrix one would best use what approach?",
            "Which of the following tubes contains an anticoagulant that inhibits thrombin?",
            "EDTA, sodium citrate, and potassium oxalate anticoagulants prevent blood clotting in blood collection tubes by:",
            "All of the following can be used to collect a serum specimen EXCEPT:",
            "The stopper colored tube that must always be filled to the correct ratio is:",
            "Which of the following is the Clinical Laboratory Standards Institute's acceptable order of tube draw?",
            "An unidentified fluid is received in the laboratory with a request to determine whether the fluid is urine or another body fluid. Using routine laboratory tests, which substances would determine that the fluid is most probably urine?",
            "The average daily output of urine is:",
            "A patient presenting with polyuria, nocturia, polydipsia, and a low urine specific gravity is exhibiting symptoms of",
            "All of the following are characteristics of recommended urine containers except:",
            "Labels for urine containers are:"
        };

        String[][] sampleOptions = {
            {"ETS Tubes", "Iodine Swab", "Safety Needle", "Tourniquet"},
            {"Light blue top", "Green top", "Plasma seperator tube", "Red top"},
            {"Concentrate the blood specimen", "Find and enter veins more easily", "Keep the veins from collapsing", "All of the above"},
            {"18-gauge", "20-gauge", "21-gauge", "23-gauge"},
            {"Arterial blood pressure", "Fist pumping from patient", "Pressure from the tourniquet", "Premeasured tube vacuum"},
            {"Quality control", "Turnaround time", "Technical competence", "Preventive maintenance"},
            {"Critical values", "Procedures", "Preventive maintenance", "Test utilization"},
            {"Technical testing of the specimen", "Collection and processing of the specimen", "Reporting and interpretation of results", "Diagnosis and treatment of the patient"},
            {"To assist in the ordering of reagents and supplies for a procedure", "To appropriately monitor the accuracy and precision of a procedure", "To ensure that all individuals perform the same task consistently", "To ensure that the appropriate test has been ordered"},
            {"Reagents (e.g., water)", "Glassware (e.g., pipettes)", "Instrumentation (e.g., microscope)", "Specimen preservation (e.g., refrigeration)"},
            {"Enzyme histochemistry", "Periodic acid-Schiff reaction", "Hematoxylin & eosin staining", "Immunohistochemistry"},
            {"Condenser", "Objective lens", "Eyepieces or ocular lenses", "Specimen slide"},
            {"The wavelength of the electrons in the microscope beam is shorter than that of a beam of light", "The lenses of an electron microscope are of greatly improved quality", "For electron microscopy the tissue specimen does not require staining", "The electron microscope allows much greater magnification of a projected image than a light microscope provides"},
            {"The types of enzymes found in various cell locations", "Cellular sites where various macromolecules are synthesized", "The sequences of mRNA made in the cells", "The dimensions of structures within the cells"},
            {"Autoradiography", "Enzyme histochemistry", "Immunohistochemistry", "Transmission electron microscopy"},
            {"Lavender stopper", "White stopper", "Light blue stopper", "Green stopper"},
            {"Binding calcium", "Binding fibrinogen", "Acting as an antithrombin agent", "Releasing heparin"},
            {"Red stopper tube", "Plasma seperator tube", "Serum seperator tube", "Orange stopper tube"},
            {"Light blue stopper tube", "Light green plasma seperator tube", "Gold serum seperator tube", "Tan stopper tube"},
            {"Light blue, light green, and lavender", "Red, light blue, and lavender", "Lavender, red, and yellow", "Yellow, green, and light blue"},
            {"Glucose and ketones", "Urea and creatinine", "Uric acid and amino acids", "Protein and amino acids"},
            {"200 mL", "500 mL", "1200 mL", "2500 mL"},
            {"Diabetes insipidus", "Diabetes mellitus", "Urinary tract infection", "Uremia"},
            {"A flat bottom", "A capacity of 50 mL", "A snap-on lid", "Are disposable"},
            {"Attached to the container", "Attached to the lid", "Placed on the container before collection", "Not detachable"},
        };

        int[] correctIndexes = {1, 3, 1, 0, 3, 1, 0, 0, 2, 3, 2, 1, 0, 1, 2, 3, 0, 2, 0, 0, 1, 2, 0, 2, 2};
        ArrayList<Integer> repeats = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = rand.nextInt(sampleQuestions.length);
                if (repeats.contains(index)){
                    while (repeats.contains(index)) {
                        index = rand.nextInt(sampleQuestions.length);
                    }
                }
                repeats.add(index);
                questions[i][j] = new Question(
                    sampleQuestions[index],
                    sampleOptions[index],
                    correctIndexes[index]
                );
            }
        }

        return questions;
    } 
}
