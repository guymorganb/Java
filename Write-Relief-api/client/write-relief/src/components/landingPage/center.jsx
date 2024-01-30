import React from 'react';
import { Box, VStack, Image } from '@chakra-ui/react';
import { motion } from 'framer-motion';

// Convert Chakra UI Box to a motion component
const MotionBox = motion(Box);

// Define your animation variants
const variants = {
    hidden: { scale: 0.8, opacity: 0 }, // Start scaled down and with opacity 0
    visible: { scale: 1, opacity: 1 }   // Scale up to normal size and opacity 1
};

const variants2 = {
    hidden: { y: -100, opacity: 0 }, // Start 20px above and with opacity 0
    visible: { y: 0, opacity: 1 }   // End at original position with opacity 1
};

export const Middle = () => {
    return (
            <Box 
                mt="2em"
                
            >
                <MotionBox
                    initial="hidden"
                    animate="visible"
                    variants={variants2}
                    transition={{
                        type: "spring", // Use a spring transition for bounce
                        stiffness: 40, // Stiffness of the spring
                        damping: 5     // How much the spring effect is dampened
                    }}
                >
                    <Image 
                            src="https://u-static.fotor.com/images/text-to-image/result/PRO-bd773f84495c438ab90d92d816de963b.jpg" 
                            alt="App Preview" 
                            objectFit="contain"
                        />
                </MotionBox>
        </Box>
    );
}
