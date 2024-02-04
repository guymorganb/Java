import React from 'react';
import { Box, Text, Link, VStack, Heading, Icon, ListItem, List, Image } from '@chakra-ui/react';
import { TbClick } from "react-icons/tb"; // Import an appropriate icon
import { motion } from 'framer-motion';
import { IconStyle } from '../../assets/custom_css_svgs/iconStyles.jsx';
import { CustomTooltip } from '../../assets/custom_css_svgs/customeTooltip.jsx';
import {TypewriterText} from '../../assets/custom_css_svgs/typewriter.jsx';
import { RightSideSvg } from '../../assets/util/backgrounds/rightSideSvg.jsx';
// Convert Chakra UI Box to a motion component
const MotionBox = motion(Box);

const variants2 = {
    hidden: { y: -100, opacity: 0 }, // Start 20px above and with opacity 0
    visible: { y: 0, opacity: 1 }   // End at original position with opacity 1
};


export const RightSide =()=>{
    return (
      
        <MotionBox
        initial="hidden"
        animate="visible"
        variants={variants2}
        transition={{
            type: "spring",
            stiffness: 40,
            damping: 5,
            delay: 6,
            duration: 8
        }}
        position="absolute" // Set the position to absolute
        top="50vh" // Align top edge
        right="-10vw" // Align right edge
        m="28"
        p="2"
        overflowY="hidden"
    >
            <Box className=" xl:w-3/5 overflow-y-hidden" >
                <Image src={`data:image/svg+xml;utf8,${encodeURIComponent(RightSideSvg)}`} alt="Right Side Image" />
            </Box>  
            
        </MotionBox>
       

    )

}