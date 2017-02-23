%% D1

yprim = @(t, y) 5*t + 5*exp(1).^(-0.5*t) - 7*y.^2;
[t y] = ode45(yprim, [1 10], 2);

plot(t, y);

% Ger fel v�rde f�r att vi inte tar h�nsyn till steg-storleken.
% y(7) ger det sjunde y-v�rdet vilket inte beh�ver st�mma �verens
% med y(t = 7)
fprintf('y(7) = %f\n', y(7));
[~,i] = min(abs(t-7)); % ~ representerar ett returnv�rde som inte anv�nds
fprintf('y(t = 7) = %f\n', y(i));

%% D2

x = [ 0.000 1.000 2.000 3.000 4.000 5.000 ];
y = [ 3.749 4.689 6.273 5.897 6.381 7.003 ];

p1 = polyfit(x, y, 5);
p2 = polyfit(x, y, 1);
x_p = linspace(-5, 5);

hold on;
plot(x, y, 'r+');
plot(x_p, polyval(p1, x_p), 'g');
plot(x_p, polyval(p2, x_p), 'b');
% �ven om polynomet passar perfekt s� �r det inte en bra modell.
% Modellen �r "�veranpassad" och representerar inte den �kande
% trenden hos m�tdatan.

%% D3

x = [ 0.10 0.20 0.30 0.40 0.50 0.60 0.70 0.80 0.90 1.00 1.10 1.20 1.30 1.40 1.50 ];
y = [ 2.41 2.83 3.04 3.01 2.93 3.08 3.48 3.54 4.16 4.06 4.11 4.49 4.13 4.66 5.12 ];

% y = a*sqrt(x + b) = a*(x + b)^(1/2)
% y^2 = a^2*(x + b) = a^2*x + a^2*b

p = polyfit(x, y.^2, 1)

% p(1) = a^2
% p(2) = a^2 * b

a = sqrt(p(1))
b = p(2)/p(1)

y_fit = @(x) a*sqrt(x + b);
x_fit = linspace(0, 1.5);

hold on;
plot(x, y, 'b+');
plot(x_fit, y_fit(x_fit), 'r');

%% D4

v = csvread('race.txt');
t = linspace(0, 40, length(v));

plot(t, v);

%% D5

v1 = csvread('race.txt');
v2 = csvread('race.txt');
t = linspace(0, 40, length(v1));

% filtrera spikar till 0
v1(v1 > 90) = 0; % []

plot(t, v1);

% filtrera spikar till n�rmaste
% funkar om inga spikar ligger brevid varandra
v2(v2 > 90) = v2(find(v2 > 90) - 1); 

figure;
plot(t, v2);

fprintf('max-hastighet: %f\n', max(v2));

%% D6

v = csvread('race.txt');
v(v > 90) = v(find(v > 90) - 1); 
t = linspace(0, 40, length(v));

s = trapz(t, v); % integrera med trapetsmetoden

fprintf('Tillryggalagd str�cka: %f m\n', s);
fprintf('Medelhastighet (v = s/t): %f m/s\n', s/40);
fprintf('Medelhastighet (mean(v)): %f m/s\n', mean(v));

%% D7

v = csvread('const_accel.txt');
t = linspace(0, 5, length(v));

plot(t, v);

%% D8

v = csvread('const_accel.txt');
t = linspace(0, 5, length(v)).';

p = polyfit(t, v, 1);

fprintf('Den (n�stan) konstanta accelerationen �r: %f m/s^2\n', p(1));

%% D9

M = 1171.42; % Nm
r = 0.3515; % m
C = 0.24;
A = 2.4; % m^2
rho = 1.29; % kg/m^3

F_motor = @(v) 4*M / r;     % K�nns b�ttre �ven om F_motor inte beror av v
F_luft = @(v) -C*rho*A*v.^2 ./ 2;
F = @(v) F_motor(v) + F_luft(v);

%% D10

m = 2107.98; % kg
M = 1171.42; % Nm
r = 0.3515; % m
C = 0.24;
A = 2.4; % m^2
rho = 1.29; % kg/m^3

F_motor = @(v) 4*M / r;     % K�nns b�ttre �ven om F_motor inte beror av v
F_luft = @(v) -C*rho*A*v.^2 ./ 2;
F = @(v) F_motor(v) + F_luft(v);

a = @(t, v) F(v) ./ m;

[t v] = ode45(a, [0 3], 0);
[~,i] = min(abs(t-3)); % ~ representerar ett returnv�rde som inte anv�nds
fprintf('Maximalt v efter 3-sek: %f m/s\n', y(i));
plot(t, v);

%% D11

