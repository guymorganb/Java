import React from 'react';
import { Box, Text, Link, VStack, Heading, Icon, ListItem, List, Image } from '@chakra-ui/react';
import { TbClick } from "react-icons/tb"; // Import an appropriate icon
import { motion } from 'framer-motion';
import { IconStyle } from '../../assets/custom_css_svgs/iconStyles.jsx';
import { CustomTooltip } from '../../assets/custom_css_svgs/customeTooltip.jsx';
import {TypewriterText} from '../../assets/custom_css_svgs/typewriter.jsx';

// Convert Chakra UI Box to a motion component
const MotionBox = motion(Box);

const variants2 = {
    hidden: { y: 100, opacity: 0 }, // Start below the view and with opacity 0
    visible: { y: 0, opacity: 1 }   // End at original position with opacity 1
};

export const Footer = () => {
    return (
        <MotionBox
            initial="hidden"
            animate="visible"
            variants={variants2}
            transition={{
                type: "spring",
                stiffness: 100,
                damping: 10,
            }}
            position="fixed" // Fixed position
            bottom="0" // Align at the bottom of the viewport
            left="0" // Align left edge to the viewport
            width="100%" // Set width to 100% of the viewport
            height="10vh" // Set height to 10% of the viewport height
            overflowY="hidden"
            backgroundColor="gray.100" // You can set the background color as needed
        >
           <Box textAlign="center">
                <Link
                    href="#"
                    color="gray.500"
                    _hover={{ textDecoration: "none", color: "gray.700" }}
                >
                    &copy; MIT
                </Link>
            </Box>
        </MotionBox>
    );
}