S = input('Sqrt approximation of: ');

f = @(x) (x + (S/x))/2;

xk1 = 0;
xk2 = S/2;
iter = 0;

while abs(xk2 - xk1) >= 1e-6
    xk1 = xk2;
    xk2 = f(xk1);
    iter = iter + 1;
end

fprintf('Iterations to converge: %d.\n', iter);