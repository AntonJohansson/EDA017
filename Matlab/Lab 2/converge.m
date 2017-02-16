function iterations = converge( z0 )
    z = z0;
    
    for iterations = 0:100
       if abs(z) > 2
           break;
       end
       
       z = z*z + z0;
    end  
end

