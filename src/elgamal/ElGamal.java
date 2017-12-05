package elgamal;

public class ElGamal {

    public static void main(String[] args) {
        int p = 31847;
        int alpha = 5;
        int beta = 18074;

        System.out.println(modExp(5, p - 20, p));
        System.out.println(modInverse(3,7));
        System.out.println(findKey(alpha,beta,p));
        
        System.out.println(modExp(5,7899,p));

    }

    /* Performs modular exponentiation
     * Uses the form a^x (mod p) */
    public static int modExp(int a, int x, int p) {
        int r = 1;
        while (x != 0) {
            if (x % 2 == 1) {
                r = (r * a) % p;
            }
            x = x / 2;
            a = (a * a) % p;
        }
        return r;
    }

    /* Performs the extended euclidean algorithm on a % p
     * Used by the modInverse function to find the modular multiplicative inverse */
    public static int[] extendedEuclidean(int a, int p) {
        int x = 0;
        int y = 1;
        int prev_x = 1;
        int prev_y = 0;
        
        while (p != 0) {
            int quotient = a / p;

            int temp = a;
            a = p;
            p = temp % p;

            temp = x;
            x = prev_x - quotient * x;
            prev_x = temp;

            temp = y;
            y = prev_y - quotient * y;
            prev_y = temp;
        }

        int res[] = {prev_x, prev_y, a};
        return res;
    }
    
    /* Obtains the coefficients of ax+py=gcd(a,p)
     * Assumes a is the base, and p is the modular value
     * Calculates the inverse for a */
    public static int modInverse(int a, int p) {
        int res[] = extendedEuclidean(a,p);
        return (res[0] + p) % p;
    }

    /* Solves the discrete log problem
     * The secretKey is found when beta == alpha^secretKey (mod p) */
    public static int findKey(int alpha, int beta, int p) {
        int secretKey = 1;
        
        while(true) {
            if (beta == modExp(alpha,secretKey,p)) {
                return secretKey;
            }
            secretKey++;
        }
    }
}
