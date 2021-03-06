package tests;


import java.util.ArrayList;

import org.junit.Test;

import algo.linearpoints.LineTracer;

import datastructures.points.Point;
import datastructures.points.PointsListsHelper;
import exceptions.WrongDataFormatException;



public class LinearPointsTest {

    @Test
    public void findLinearPointsTest() throws WrongDataFormatException{
        ArrayList<Point> points = PointsListsHelper.createPointsList(
            0, 11.397, 13.000  ,
            1, 39.498, 44.932  ,
            2, 43.759, 49.774  ,
            3, 0.018, 0.069  ,
            4, 26.400, 30.048 , 
            5, 60.239, 68.501  ,
            6, 65.563, 74.551  ,
            7, 52.615, 59.837  ,
            8, 27.822, 31.664  ,
            9, 65.432, 74.401  ,
            10, 96.881, 110.139 , 
            11, 51.490, 58.559  ,
            12, 84.765, 96.371  ,
            13, 56.919, 64.728  ,
            14, 71.903, 81.755  ,
            15, 12.474, 14.224  ,
            16, 81.569, 92.739  ,
            17, 86.434, 98.267  ,
            18, 96.212, 109.378  ,
            19, 1.169, 1.378  ,
            20, 76.549, 87.034 , 
            21, 33.026, 37.578  ,
            22, 86.978, 98.884  ,
            23, 86.148, 97.942  ,
            24, 83.588, 95.033  ,
            25, 89.310, 101.534  ,
            26, 12.498, 14.251  ,
            27, 65.184, 74.120  ,
            28, 57.827, 65.759  ,
            29, 63.375, 72.064  ,
            30, 89.534, 101.789  ,
            31, 2.060, 2.390  ,
            32, 93.736, 106.564,  
            33, 93.561, 106.365 , 
            34, 31.730, 36.105  ,
            35, 22.178, 25.251  ,
            36, 11.548, 13.172  ,
            37, 29.209, 33.241  ,
            38, 67.926, 77.235  ,
            39, 41.437, 47.135  ,
            40, 16.312, 18.585  ,
            41, 52.144, 59.302  ,
            42, 46.126, 66.620  ,
            43, 31.087, 45.044  ,
            44, 39.634, 57.305  ,
            45, 27.692, 40.173  ,
            46, 9.253, 13.719  ,
            47, 6.684, 10.033  ,
            48, 34.954, 50.592  ,
            49, 92.535, 133.202  ,
            50, 67.051, 96.641  ,
            51, 47.312, 68.322  ,
            52, 18.597, 27.125  ,
            53, 16.656, 24.340  ,
            54, 30.810, 44.647  ,
            55, 74.755, 107.693  ,
            56, 89.110, 128.289  ,
            57, 43.334, 62.615  ,
            58, 88.525, 127.449  ,
            59, 52.084, 75.167  ,
            60, 56.437, 89.919  ,
            61, 56.113, 89.405  ,
            62, 74.239, 118.192  ,
            63, 65.642, 104.539  ,
            64, 79.595, 126.699  ,
            65, 83.115, 132.290  ,
            66, 9.835, 15.905  ,
            67, 45.154, 71.998  ,
            68, 66.511, 105.918  ,
            69, 54.450, 86.763  ,
            70, 83.091, 132.252  ,
            71, 68.314, 108.782  ,
            72, 11.090, 17.897  ,
            73, 71.835, 114.374  ,
            74, 69.957, 111.392  ,
            75, 11.407, 18.401  ,
            76, 45.078, 71.879  ,
            77, 0.193, 0.591  ,
            78, 69.011, 109.889,  
            79, 84.910, 135.140 , 
            80, 2.158, 3.712  ,
            81, 70.984, 113.022,  
            82, 29.139, 46.564  ,
            83, 11.549, 18.627  ,
            84, 90.318, 143.730  ,
            85, 53.493, 85.243  ,
            86, 78.620, 125.150  ,
            87, 12.220, 19.693  ,
            88, 99.678, 158.595  ,
            89, 42.283, 74.621  ,
            90, 43.771, 77.231  ,
            91, 57.142, 100.687  ,
            92, 44.788, 79.015  ,
            93, 46.161, 81.423  ,
            94, 27.208, 48.176  ,
            95, 79.437, 139.796  ,
            96, 19.063, 33.889  ,
            97, 3.103, 5.890  ,
            98, 50.586, 89.185 , 
            99, 54.981, 96.895  ,
            100, 82.440, 145.064 , 
            101, 82.119, 144.501  ,
            102, 16.248, 28.950  ,
            103, 1.070, 2.325  ,
            104, 17.137, 30.510 , 
            105, 68.298, 120.256 , 
            106, 86.769, 152.659  ,
            107, 46.236, 81.555  ,
            108, 68.526, 120.656  ,
            109, 24.445, 43.329  ,
            110, 41.613, 63.220  ,
            111, 49.492, 75.131  ,
            112, 52.880, 80.254  ,
            113, 29.025, 44.190  ,
            114, 91.121, 138.067  ,
            115, 84.389, 127.889  ,
            116, 53.045, 102.299  ,
            117, 43.362, 83.732  ,
            118, 63.117, 121.612  ,
            119, 21.065, 40.977  ,
            120, 24.744, 48.032  ,
            121, 63.107, 121.591  ,
            122, 4.424, 9.069  ,
            123, 1.972, 4.367  ,
            124, 51.073, 98.518 , 
            125, 10.496, 20.712  ,
            126, 92.623, 178.189  ,
            127, 2.695, 5.754  ,
            128, 68.853, 132.611,  
            129, 54.083, 104.288 , 
            130, 32.186, 62.302  ,
            131, 53.723, 103.598  ,
            132, 14.651, 28.679  ,
            133, 52.871, 101.965  ,
            134, 31.364, 60.725  ,
            135, 38.638, 74.673  ,
            136, 46.521, 48.501  ,
            137, 51.138, 53.294  ,
            138, 68.822, 71.649  ,
            139, 86.031, 89.510  ,
            140, 21.456, 22.486  ,
            141, 79.283, 82.506  ,
            142, 26.931, 28.168  ,
            143, 5.748, 6.182  ,
            144, 75.734, 78.822 , 
            145, 55.299, 57.613  ,
            146, 5.855, 6.293  ,
            147, 83.403, 86.782 , 
            148, 71.964, 74.910  ,
            149, 6.746, 7.218  ,
            150, 74.123, 77.150 , 
            151, 23.699, 24.814  ,
            152, 5.480, 5.904  ,
            153, 70.486, 73.375 , 
            154, 90.649, 94.303  ,
            155, 42.096, 57.262  ,
            156, 87.779, 118.919  ,
            157, 47.570, 64.650  ,
            158, 33.034, 45.031  ,
            159, 38.827, 52.850  ,
            160, 11.265, 15.651  ,
            161, 76.917, 104.258  ,
            162, 20.441, 28.036  ,
            163, 71.003, 96.277  ,
            164, 89.471, 119.546  ,
            165, 78.137, 104.509  ,
            166, 37.774, 50.960  ,
            167, 99.212, 132.469  ,
            168, 16.725, 23.035  ,
            169, 3.518, 5.512  ,
            170, 99.189, 132.438,  
            171, 12.958, 18.037  ,
            172, 24.557, 33.425  ,
            173, 38.888, 52.438  ,
            174, 34.055, 46.026  ,
            175, 13.042, 18.148  ,
            176, 91.706, 122.511  ,
            177, 75.513, 101.028  ,
            178, 98.723, 131.820  ,
            179, 91.683, 99.034  ,
            180, 50.260, 54.395  ,
            181, 28.124, 30.541  ,
            182, 89.523, 96.707  ,
            183, 59.942, 64.829  ,
            184, 47.133, 51.026  ,
            185, 52.165, 56.449  ,
            186, 6.381, 7.111  ,
            187, 49.041, 53.082 , 
            188, 33.671, 36.518  ,
            189, 64.812, 70.078  ,
            190, 55.291, 59.817  ,
            191, 52.756, 57.086  ,
            192, 44.766, 48.475  ,
            193, 54.183, 58.624  ,
            194, 83.089, 89.774  ,
            195, 52.997, 57.345  ,
            196, 76.723, 82.913  ,
            197, 81.090, 87.619  ,
            198, 36.015, 39.045  ,
            199, 3.340, 3.833  ,
            200, 26.673, 28.977 , 
            201, 90.424, 97.678  ,
            202, 32.609, 35.374  ,
            203, 84.252, 91.026  ,
            204, 85.040, 91.876  ,
            205, 9.808, 10.804  ,
            206, 71.701, 77.501  ,
            207, 62.921, 68.039  ,
            208, 94.770, 102.361  ,
            209, 44.234, 47.901  ,
            210, 76.347, 82.508  ,
            211, 43.037, 46.612  ,
            212, 47.342, 51.251  ,
            213, 41.952, 45.443  ,
            214, 7.473, 8.287  ,
            215, 95.461, 103.106,  
            216, 20.118, 21.914  ,
            217, 76.488, 82.660  ,
            218, 42.029, 45.526  ,
            219, 19.373, 21.111  ,
            220, 72.115, 77.948
            );
        
        ArrayList<ArrayList<Point>> allLists = LineTracer.findAllUniqueLines(points, 0.0001);
        ArrayList<Point> longest = LineTracer.determineLongestList(allLists);
        System.out.println(longest.size());
    }
}
