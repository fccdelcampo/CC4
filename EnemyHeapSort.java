public class EnemyHeapSort {

    public static int stepCount = 0;

    public static void sort(int arr[]) {
        int n = arr.length;
        stepCount++; // 1 statement

        // Build heap (rearrange array)
        stepCount++; // initialization for for-loop
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
            stepCount += 3; // +3 step count for conditional, body statement, and change of state
        }
        stepCount += 3; // +2 step count for 2 unmet conditionals and end curly brace

        // One by one extract an element from heap
        stepCount++; // initialization for for-loop
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
            stepCount += 6; // +6 step count for conditional check, 4 statements, and change of state
        }
        stepCount += 3; // // +3 step count for 2 unmet conditionals and end curly brace
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
        stepCount += 3; // 3 statements

        // If left child is larger than root
        stepCount++; // if statement checked
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
            stepCount += 2; // statement executed and end curly brace
        }

        // If right child is larger than largest so far
        stepCount++; // if statement checked
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
            stepCount++; // statement executed and end curly brace
        }

        // If largest is not root
        stepCount++; // if statement checked
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);

            stepCount += 5; // +6 step count for 4 statements and end curly brace
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int[] trial1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386, 387, 388, 389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422, 423, 424, 425, 426, 427, 428, 429, 430, 431, 432, 433, 434, 435, 436, 437, 438, 439, 440, 441, 442, 443, 444, 445, 446, 447, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 463, 464, 465, 466, 467, 468, 469, 470, 471, 472, 473, 474, 475, 476, 477, 478, 479, 480, 481, 482, 483, 484, 485, 486, 487, 488, 489, 490, 491, 492, 493, 494, 495, 496, 497, 498, 499, 500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511, 512, 513, 514, 515, 516, 517, 518, 519, 520, 521, 522, 523, 524, 525, 526, 527, 528, 529, 530, 531, 532, 533, 534, 535, 536, 537, 538, 539, 540, 541, 542, 543, 544, 545, 546, 547, 548, 549, 550, 551, 552, 553, 554, 555, 556, 557, 558, 559, 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 579, 580, 581, 582, 583, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 599, 600, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 614, 615, 616, 617, 618, 619, 620, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636, 637, 638, 639, 640, 641, 642, 643, 644, 645, 646, 647, 648, 649, 650, 651, 652, 653, 654, 655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665, 666, 667, 668, 669, 670, 671, 672, 673, 674, 675, 676, 677, 678, 679, 680, 681, 682, 683, 684, 685, 686, 687, 688, 689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703, 704, 705, 706, 707, 708, 709, 710, 711, 712, 713, 714, 715, 716, 717, 718, 719, 720, 721, 722, 723, 724, 725, 726, 727, 728, 729, 730, 731, 732, 733, 734, 735, 736, 737, 738, 739, 740, 741, 742, 743, 744, 745, 746, 747, 748, 749, 750, 751, 752, 753, 754, 755, 756, 757, 758, 759, 760, 761, 762, 763, 764, 765, 766, 767, 768, 769, 770, 771, 772, 773, 774, 775, 776, 777, 778, 779, 780, 781, 782, 783, 784, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831, 832, 833, 834, 835, 836, 837, 838, 839, 840, 841, 842, 843, 844, 845, 846, 847, 848, 849, 850, 851, 852, 853, 854, 855, 856, 857, 858, 859, 860, 861, 862, 863, 864, 865, 866, 867, 868, 869, 870, 871, 872, 873, 874, 875, 876, 877, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 911, 912, 913, 914, 915, 916, 917, 918, 919, 920, 921, 922, 923, 924, 925, 926, 927, 928, 929, 930, 931, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945, 946, 947, 948, 949, 950, 951, 952, 953, 954, 955, 956, 957, 958, 959, 960, 961, 962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973, 974, 975, 976, 977, 978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, 989, 990, 991, 992, 993, 994, 995, 996, 997, 998, 999, 1000};

        int[] trial2 = {1000, 999, 998, 997, 996, 995, 994, 993, 992, 991, 990, 989, 988, 987, 986, 985, 984, 983, 982, 981, 980, 979, 978, 977, 976, 975, 974, 973, 972, 971, 970, 969, 968, 967, 966, 965, 964, 963, 962, 961, 960, 959, 958, 957, 956, 955, 954, 953, 952, 951, 950, 949, 948, 947, 946, 945, 944, 943, 942, 941, 940, 939, 938, 937, 936, 935, 934, 933, 932, 931, 930, 929, 928, 927, 926, 925, 924, 923, 922, 921, 920, 919, 918, 917, 916, 915, 914, 913, 912, 911, 910, 909, 908, 907, 906, 905, 904, 903, 902, 901, 900, 899, 898, 897, 896, 895, 894, 893, 892, 891, 890, 889, 888, 887, 886, 885, 884, 883, 882, 881, 880, 879, 878, 877, 876, 875, 874, 873, 872, 871, 870, 869, 868, 867, 866, 865, 864, 863, 862, 861, 860, 859, 858, 857, 856, 855, 854, 853, 852, 851, 850, 849, 848, 847, 846, 845, 844, 843, 842, 841, 840, 839, 838, 837, 836, 835, 834, 833, 832, 831, 830, 829, 828, 827, 826, 825, 824, 823, 822, 821, 820, 819, 818, 817, 816, 815, 814, 813, 812, 811, 810, 809, 808, 807, 806, 805, 804, 803, 802, 801, 800, 799, 798, 797, 796, 795, 794, 793, 792, 791, 790, 789, 788, 787, 786, 785, 784, 783, 782, 781, 780, 779, 778, 777, 776, 775, 774, 773, 772, 771, 770, 769, 768, 767, 766, 765, 764, 763, 762, 761, 760, 759, 758, 757, 756, 755, 754, 753, 752, 751, 750, 749, 748, 747, 746, 745, 744, 743, 742, 741, 740, 739, 738, 737, 736, 735, 734, 733, 732, 731, 730, 729, 728, 727, 726, 725, 724, 723, 722, 721, 720, 719, 718, 717, 716, 715, 714, 713, 712, 711, 710, 709, 708, 707, 706, 705, 704, 703, 702, 701, 700, 699, 698, 697, 696, 695, 694, 693, 692, 691, 690, 689, 688, 687, 686, 685, 684, 683, 682, 681, 680, 679, 678, 677, 676, 675, 674, 673, 672, 671, 670, 669, 668, 667, 666, 665, 664, 663, 662, 661, 660, 659, 658, 657, 656, 655, 654, 653, 652, 651, 650, 649, 648, 647, 646, 645, 644, 643, 642, 641, 640, 639, 638, 637, 636, 635, 634, 633, 632, 631, 630, 629, 628, 627, 626, 625, 624, 623, 622, 621, 620, 619, 618, 617, 616, 615, 614, 613, 612, 611, 610, 609, 608, 607, 606, 605, 604, 603, 602, 601, 600, 599, 598, 597, 596, 595, 594, 593, 592, 591, 590, 589, 588, 587, 586, 585, 584, 583, 582, 581, 580, 579, 578, 577, 576, 575, 574, 573, 572, 571, 570, 569, 568, 567, 566, 565, 564, 563, 562, 561, 560, 559, 558, 557, 556, 555, 554, 553, 552, 551, 550, 549, 548, 547, 546, 545, 544, 543, 542, 541, 540, 539, 538, 537, 536, 535, 534, 533, 532, 531, 530, 529, 528, 527, 526, 525, 524, 523, 522, 521, 520, 519, 518, 517, 516, 515, 514, 513, 512, 511, 510, 509, 508, 507, 506, 505, 504, 503, 502, 501, 500, 499, 498, 497, 496, 495, 494, 493, 492, 491, 490, 489, 488, 487, 486, 485, 484, 483, 482, 481, 480, 479, 478, 477, 476, 475, 474, 473, 472, 471, 470, 469, 468, 467, 466, 465, 464, 463, 462, 461, 460, 459, 458, 457, 456, 455, 454, 453, 452, 451, 450, 449, 448, 447, 446, 445, 444, 443, 442, 441, 440, 439, 438, 437, 436, 435, 434, 433, 432, 431, 430, 429, 428, 427, 426, 425, 424, 423, 422, 421, 420, 419, 418, 417, 416, 415, 414, 413, 412, 411, 410, 409, 408, 407, 406, 405, 404, 403, 402, 401, 400, 399, 398, 397, 396, 395, 394, 393, 392, 391, 390, 389, 388, 387, 386, 385, 384, 383, 382, 381, 380, 379, 378, 377, 376, 375, 374, 373, 372, 371, 370, 369, 368, 367, 366, 365, 364, 363, 362, 361, 360, 359, 358, 357, 356, 355, 354, 353, 352, 351, 350, 349, 348, 347, 346, 345, 344, 343, 342, 341, 340, 339, 338, 337, 336, 335, 334, 333, 332, 331, 330, 329, 328, 327, 326, 325, 324, 323, 322, 321, 320, 319, 318, 317, 316, 315, 314, 313, 312, 311, 310, 309, 308, 307, 306, 305, 304, 303, 302, 301, 300, 299, 298, 297, 296, 295, 294, 293, 292, 291, 290, 289, 288, 287, 286, 285, 284, 283, 282, 281, 280, 279, 278, 277, 276, 275, 274, 273, 272, 271, 270, 269, 268, 267, 266, 265, 264, 263, 262, 261, 260, 259, 258, 257, 256, 255, 254, 253, 252, 251, 250, 249, 248, 247, 246, 245, 244, 243, 242, 241, 240, 239, 238, 237, 236, 235, 234, 233, 232, 231, 230, 229, 228, 227, 226, 225, 224, 223, 222, 221, 220, 219, 218, 217, 216, 215, 214, 213, 212, 211, 210, 209, 208, 207, 206, 205, 204, 203, 202, 201, 200, 199, 198, 197, 196, 195, 194, 193, 192, 191, 190, 189, 188, 187, 186, 185, 184, 183, 182, 181, 180, 179, 178, 177, 176, 175, 174, 173, 172, 171, 170, 169, 168, 167, 166, 165, 164, 163, 162, 161, 160, 159, 158, 157, 156, 155, 154, 153, 152, 151, 150, 149, 148, 147, 146, 145, 144, 143, 142, 141, 140, 139, 138, 137, 136, 135, 134, 133, 132, 131, 130, 129, 128, 127, 126, 125, 124, 123, 122, 121, 120, 119, 118, 117, 116, 115, 114, 113, 112, 111, 110, 109, 108, 107, 106, 105, 104, 103, 102, 101, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        int[] trial3 = {54, 781, 150, 226, 481, 629, 658, 917, 945, 230, 676, 36, 395, 22, 462, 819, 904, 262, 618, 304, 607, 378, 162, 334, 408, 210, 599, 52, 688, 924, 20, 139, 260, 65, 452, 13, 951, 515, 958, 18, 415, 936, 701, 463, 87, 476, 572, 172, 169, 544, 429, 814, 763, 99, 582, 530, 567, 194, 256, 505, 356, 363, 692, 985, 50, 155, 357, 509, 518, 122, 4, 405, 570, 202, 484, 526, 12, 722, 208, 104, 396, 868, 633, 973, 734, 458, 83, 525, 335, 205, 506, 537, 859, 31, 148, 769, 678, 642, 591, 203, 940, 905, 649, 602, 387, 712, 129, 74, 827, 196, 223, 783, 608, 615, 124, 342, 377, 634, 983, 56, 369, 64, 804, 496, 510, 745, 209, 117, 907, 865, 206, 548, 837, 598, 729, 892, 707, 233, 93, 576, 225, 611, 322, 808, 668, 161, 487, 337, 274, 891, 7, 573, 236, 494, 848, 218, 451, 58, 220, 937, 728, 144, 834, 173, 883, 622, 800, 126, 384, 807, 620, 10, 791, 970, 44, 742, 992, 969, 516, 923, 840, 379, 382, 835, 235, 361, 9, 24, 843, 794, 163, 740, 925, 212, 571, 869, 238, 116, 876, 353, 796, 645, 824, 51, 349, 682, 887, 219, 134, 939, 993, 177, 976, 186, 1, 971, 947, 886, 604, 706, 417, 107, 275, 782, 575, 720, 867, 386, 519, 595, 829, 380, 164, 198, 78, 986, 273, 419, 428, 246, 370, 371, 459, 135, 909, 813, 680, 106, 400, 214, 111, 934, 675, 227, 954, 314, 798, 123, 659, 398, 705, 425, 401, 300, 785, 935, 703, 630, 926, 296, 82, 89, 854, 332, 790, 626, 553, 805, 367, 929, 816, 534, 662, 577, 138, 966, 171, 979, 392, 224, 803, 295, 863, 413, 514, 893, 77, 673, 271, 174, 170, 156, 764, 760, 270, 360, 727, 875, 888, 889, 551, 340, 121, 112, 19, 670, 679, 961, 592, 779, 372, 663, 822, 980, 957, 594, 365, 60, 789, 485, 142, 317, 411, 445, 914, 137, 787, 775, 696, 488, 75, 176, 975, 448, 653, 788, 437, 145, 242, 999, 878, 901, 261, 833, 702, 493, 625, 677, 433, 558, 318, 632, 68, 756, 190, 545, 842, 483, 995, 884, 759, 266, 546, 911, 987, 870, 797, 88, 568, 49, 316, 98, 684, 247, 191, 90, 465, 393, 912, 28, 114, 974, 694, 566, 517, 168, 762, 557, 477, 443, 96, 165, 857, 683, 639, 251, 627, 871, 250, 802, 962, 825, 550, 861, 560, 175, 539, 35, 989, 385, 874, 731, 922, 580, 772, 26, 333, 902, 542, 301, 636, 201, 856, 480, 671, 326, 72, 147, 253, 640, 897, 92, 309, 62, 491, 427, 528, 758, 749, 211, 412, 338, 185, 527, 280, 294, 133, 938, 497, 399, 955, 288, 691, 723, 915, 2, 828, 817, 140, 418, 118, 597, 721, 81, 746, 373, 606, 952, 628, 916, 984, 908, 200, 753, 229, 343, 549, 17, 661, 669, 777, 674, 771, 624, 770, 697, 991, 593, 845, 855, 503, 438, 486, 584, 195, 420, 439, 617, 376, 424, 801, 500, 97, 574, 324, 881, 39, 115, 603, 644, 880, 748, 502, 237, 263, 489, 289, 795, 686, 741, 14, 215, 656, 466, 268, 621, 158, 178, 690, 180, 953, 811, 351, 362, 410, 943, 86, 109, 94, 339, 183, 468, 655, 589, 498, 321, 160, 473, 102, 654, 858, 619, 328, 61, 37, 877, 53, 853, 850, 693, 276, 241, 815, 885, 647, 213, 698, 685, 600, 717, 66, 414, 446, 472, 315, 248, 347, 344, 464, 765, 222, 33, 67, 38, 643, 312, 832, 30, 306, 910, 143, 406, 918, 773, 754, 325, 120, 127, 866, 623, 279, 388, 331, 40, 132, 841, 664, 714, 531, 520, 784, 719, 778, 507, 873, 95, 972, 960, 941, 84, 305, 292, 244, 245, 320, 933, 650, 297, 715, 330, 298, 436, 533, 282, 442, 689, 404, 823, 810, 70, 76, 511, 776, 852, 450, 403, 747, 16, 187, 726, 732, 423, 457, 757, 21, 1000, 495, 799, 234, 588, 616, 27, 389, 125, 766, 283, 149, 563, 474, 927, 535, 587, 284, 718, 586, 559, 204, 231, 821, 739, 657, 434, 949, 818, 313, 69, 648, 354, 736, 130, 737, 471, 255, 994, 441, 613, 536, 416, 959, 57, 792, 847, 687, 402, 585, 240, 128, 581, 512, 931, 350, 390, 767, 359, 430, 6, 336, 46, 456, 864, 504, 348, 997, 920, 375, 730, 469, 882, 761, 110, 55, 849, 490, 182, 394, 269, 23, 666, 189, 579, 752, 152, 900, 532, 254, 651, 346, 358, 32, 601, 990, 709, 894, 750, 166, 903, 564, 665, 192, 826, 181, 836, 221, 838, 281, 738, 521, 188, 146, 583, 80, 860, 232, 831, 540, 681, 913, 435, 119, 699, 34, 996, 48, 988, 426, 113, 830, 751, 713, 499, 529, 264, 207, 151, 501, 704, 447, 879, 846, 366, 108, 641, 635, 307, 327, 444, 596, 136, 397, 341, 258, 364, 154, 291, 735, 967, 475, 950, 461, 522, 508, 786, 899, 919, 552, 3, 91, 780, 272, 556, 47, 285, 249, 921, 103, 239, 252, 41, 942, 455, 352, 15, 898, 319, 159, 513, 193, 652, 302, 646, 895, 839, 793, 299, 844, 265, 449, 179, 45, 981, 605, 978, 724, 710, 287, 293, 29, 407, 538, 523, 660, 453, 184, 896, 479, 725, 565, 42, 383, 716, 733, 63, 590, 278, 610, 467, 71, 948, 482, 101, 862, 167, 59, 561, 257, 470, 946, 323, 755, 700, 216, 569, 820, 809, 562, 977, 612, 199, 806, 932, 667, 303, 79, 259, 965, 695, 329, 431, 277, 243, 982, 5, 422, 998, 157, 964, 928, 228, 345, 308, 711, 768, 547, 963, 554, 85, 391, 421, 311, 872, 906, 543, 73, 743, 432, 43, 381, 25, 672, 100, 851, 631, 744, 930, 8, 609, 708, 355, 11, 774, 492, 478, 440, 368, 637, 267, 290, 460, 454, 310, 197, 105, 541, 217, 374, 812, 555, 968, 890, 638, 153, 944, 614, 409, 578, 286, 956, 131, 141, 524};
        

        System.out.println("======================================================");
        System.out.println("HEAP SORT");
        System.out.println("==============UNSORTED ARRAY TRIAL 1==================");
        printArray(trial1);
        System.out.println("==============UNSORTED ARRAY TRIAL 2==================");
        printArray(trial2);
        System.out.println("==============UNSORTED ARRAY TRIAL 3==================");
        printArray(trial3);
        System.out.println("======================================================");
        
        // Function call
        stepCount = 1;
        sort(trial1);
        stepCount++;
        int TFC1 = stepCount;
        System.out.println("Total step count for heapsort of trial 1: " + stepCount);

        stepCount = 1;
        sort(trial2);
        stepCount++;
        int TFC2 = stepCount;
        System.out.println("Total step count for heapsort of trial 2: " + stepCount);

        stepCount = 1;
        sort(trial3);
        stepCount++;
        int TFC3 = stepCount;
        System.out.println("Total step count for heapsort of trial 3: " + stepCount);

        System.out.println("======================================================");

        System.out.println("Average step count for the three trials: " + Math.round((TFC1 + TFC2 + TFC3) / 3.0));
        System.out.println("======================================================");

        System.out.println("SORTED ARRAY 1");
        printArray(trial1);
        System.out.println("SORTED ARRAY 2");
        printArray(trial2);
        System.out.println("SORTED ARRAY 3");
        printArray(trial3);

    }
}
