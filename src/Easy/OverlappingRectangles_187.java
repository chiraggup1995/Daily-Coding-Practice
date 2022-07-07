package Easy;

/*
Problem:
You are given given a list of rectangles represented by min and max x- and
y-coordinates. Compute whether or not a pair of rectangles overlap each other. If one
rectangle completely covers another, it is considered overlapping.
For example, given the following rectangles:
{
    "top_left": (1, 4),
    "dimensions": (3, 3) # width, height
},
{
    "top_left": (-1, 3),
    "dimensions": (2, 1)
},
{
    "top_left": (0, 5),
    "dimensions": (4, 4) #Modified
}
return true as the first and third rectangle overlap each other.
*/
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingRectangles_187 {


        public static class Rectangle
        {
            int x1;
            int y1;
            int width;
            int height;
            String label;
            public Rectangle(int x1, int y1, int width, int height, String label){
                this.x1 = x1;
                this.y1 = y1;
                this.width = width;
                this.height = height;
                this.label = label;
            }
        }

        public int findIntersectionArea(Rectangle r1, Rectangle r2){
            //Calculate coordinates for bottom right of both rectangles
            int R1_x2 =r1.x1 + r1.width;
            int R1_y2 =r1.y1 - r1.height;
            int R2_x2 =r2.x1 + r2.width;
            int R2_y2=r2.y1- r2.height;
            //Find Ovverlapping Rectangle by calculating its x_distance & y_distance overlapped
            int x_distance = Math.min(R1_x2, R2_x2) - Math.max(r1.x1, r2.x1);
            int y_distance = Math.min(r1.y1, r2.y1) - Math.max(R1_y2, R2_y2);
            return x_distance * y_distance;

        }

        public int getArea(Rectangle r1){
            return r1.height * r1.width;

        }

        public void findOverlappingRectangles(List<Rectangle> rectangleList){
            int overlappingArea;
            int totalArea_1;
            int totalArea_2;
            List<Pair<String, String>> result = new ArrayList<>();
            for(int i = 0 ; i < rectangleList.size(); i++){
                for(int j = i+1; j < rectangleList.size(); j++){
                    overlappingArea = findIntersectionArea(rectangleList.get(i), rectangleList.get(j));
                    totalArea_1 = getArea(rectangleList.get(i));
                    totalArea_2 = getArea(rectangleList.get(j));
                    //System.out.println(overlappingArea + " " +totalArea_1 + " " +totalArea_2);
                    if(overlappingArea == totalArea_1 || overlappingArea == totalArea_2){
                        result.add(new Pair(rectangleList.get(i).label, rectangleList.get(j).label));
                    }
                }
            }
            if(result.size() > 0){
                System.out.println("True");
            }
            else{
                System.out.println("False");
            }

            for(Pair pair : result){
                System.out.println(pair.getKey() + " " + pair.getValue());
            }


        }

        public static void main(String... strings){
            Rectangle r1 = new Rectangle(1,4,3,3, "r1");
            Rectangle r2 = new Rectangle(-1,3,2,1, "r2");
            Rectangle r3 = new Rectangle(0,5,4,4, "r3");
            List<Rectangle> rectangleList = new ArrayList<>(Arrays.asList(r1,r2,r3));
            OverlappingRectangles_187 overlappingRectangle_187 = new OverlappingRectangles_187();
            overlappingRectangle_187.findOverlappingRectangles(rectangleList);

        }
    }

